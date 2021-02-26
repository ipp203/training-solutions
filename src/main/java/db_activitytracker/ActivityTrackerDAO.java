package db_activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerDAO {
    MariaDbDataSource dataSource;

    public ActivityTrackerDAO(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Activity saveActivity(Activity activity) {
        Activity result = new Activity(activity);
        long activityId = saveToActivitiesTable(activity);
        result.setId(activityId);
        saveTrackPointsToTable(result.getTrackPoints(), activityId);
        return result;
    }

    public List<Activity> saveActivities(List<Activity> activities) {

        String sqlQuery = getSqlQuery(activities);
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {

            int i = 1;
            for (Activity activity : activities) {
                pstmt.setTimestamp(i++, Timestamp.valueOf(activity.getStartTime()));
                pstmt.setString(i++, activity.getDesc());
                pstmt.setString(i++, activity.getType().toString());
            }
            pstmt.executeUpdate();

            List<Long> ids = getIdsByPreparedStatement(pstmt);
            setIdInActivities(activities, ids);
            for (Activity activity : activities) {
                saveTrackPointsToTable(activity.getTrackPoints(), activity.getId());
            }
            return activities;

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Can not connect", sqle);
        }

    }

    private String getSqlQuery(List<Activity> activities) {
        String sqlQuery = "INSERT INTO activities(start_time, activity_desc, activity_type) VALUES" +
                "(?,?,?),".repeat(activities.size());
        return sqlQuery.substring(0, sqlQuery.length() - 1);
    }

    private void setIdInActivities(List<Activity> activities, List<Long> ids) {
        for (int j = 0; j < activities.size(); j++) {
            activities.get(j).setId(ids.get(j));
        }
    }

    private List<Long> getIdsByPreparedStatement(PreparedStatement pstmt) {
        List<Long> result = new ArrayList<>();
        try (ResultSet rs = pstmt.getGeneratedKeys()) {
            while (rs.next()) {
                result.add(rs.getLong("id"));
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not get generated key", sqle);
        }
    }

    private long getIdByPreparedStatement(PreparedStatement pstmt) {
        try (ResultSet rs = pstmt.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getLong("id");
            }
            throw new SQLException("Id not exists");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not get generated key", sqle);
        }
    }


    private void saveTrackPointsToTable(List<TrackPoint> trackPoints, long activityId) {
        try (Connection conn = dataSource.getConnection()) {

            conn.setAutoCommit(false);
            saveTrackPointsByConnection(trackPoints, activityId, conn);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect to track_point table", sqle);
        }
    }

    private void saveTrackPointsByConnection(List<TrackPoint> trackPoints, long activityId, Connection conn) {
        try (PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO track_point(track_time, lat, lon, activity_id) VALUES(?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS)) {

            try {
                saveTrackPointsByPreparedStatement(activityId, pstmt, trackPoints);
                conn.commit();
            } catch (IllegalArgumentException iae) {
                conn.rollback();
            }

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not insert to track_point table", sqle);
        }
    }

    private void saveTrackPointsByPreparedStatement(long activityId, PreparedStatement pstmt, List<TrackPoint> trackPoints) throws SQLException {
        for (TrackPoint tp : trackPoints) {
            pstmt.setTimestamp(1, Timestamp.valueOf(tp.getTime()));
            if (tp.getLat() > -90 && tp.getLat() <= 90) {
                pstmt.setDouble(2, tp.getLat());
            } else {
                throw new IllegalArgumentException("Latitude out of bounds");
            }
            if (tp.getLon() > -180 && tp.getLon() <= 180) {
                pstmt.setDouble(3, tp.getLon());
            } else {
                throw new IllegalArgumentException("Longitude out of bounds");
            }
            pstmt.setLong(4, activityId);
            pstmt.executeUpdate();
            long trackPointId = getIdByPreparedStatement(pstmt);
            tp.setId(trackPointId);
        }
    }

    private long saveToActivitiesTable(Activity activity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO activities(start_time, activity_desc, activity_type) VALUES(?,?,?)",
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            pstmt.setString(2, activity.getDesc());
            pstmt.setString(3, activity.getType().toString());
            pstmt.executeUpdate();
            return getIdByPreparedStatement(pstmt);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not insert to activities table", sqle);
        }
    }


    public Activity findActivityById(long id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT id, start_time, activity_desc, activity_type FROM activities WHERE id = ?")) {

            pstmt.setLong(1, id);
            List<Activity> result = selectActivitiesByPreparedStatement(pstmt);
            if (result.isEmpty()) {
                throw new IllegalArgumentException("Activity not found ");
            }
            return result.get(0);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect", sqle);
        }
    }

    public List<Activity> listActivities() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt =
                     conn.prepareStatement("SELECT * FROM activities")) {

            List<Activity> result = selectActivitiesByPreparedStatement(pstmt);
            if (result.isEmpty()) {
                throw new IllegalArgumentException("Activity not found ");
            }
            return result;

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect", sqle);
        }
    }

    private List<Activity> selectActivitiesByPreparedStatement(PreparedStatement pstmt) {
        try (ResultSet rs = pstmt.executeQuery()) {

            List<Activity> result = new ArrayList<>();
            while (rs.next()) {
                long id = rs.getLong("id");
                LocalDateTime ldt = rs.getTimestamp("start_time").toLocalDateTime();
                String desc = rs.getString("activity_desc");
                Type type = Type.valueOf(rs.getString("activity_type"));
                Activity tempActivity = new Activity(id, ldt, desc, type);
                selectTrackPointsToActivity(tempActivity);

                result.add(tempActivity);
            }
            return result;

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not select from table", sqle);
        }
    }

    private void selectTrackPointsToActivity(Activity activity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM track_point WHERE activity_id = ?")) {

            pstmt.setLong(1, activity.getId());
            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    TrackPoint trackPoint = new TrackPoint(
                            rs.getLong("id"),
                            rs.getTimestamp("track_time").toLocalDateTime(),
                            rs.getDouble("lat"),
                            rs.getDouble("lon"));
                    activity.addTrackPoint(trackPoint);
                }

            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Can not select trackpoints", sqle);
            }

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Can not connect to select trackpoints", sqle);
        }
    }


}