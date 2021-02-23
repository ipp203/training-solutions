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

    public void saveActivity(Activity activity) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(
                        "INSERT INTO activities(start_time, activity_desc, activity_type) VALUES(?,?,?)")
        ) {

            pstmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            pstmt.setString(2, activity.getDesc());
            pstmt.setString(3, activity.getType().toString());
            pstmt.executeUpdate();

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not insert to activities table " + sqle.getMessage(), sqle);
        }
    }

    public Activity findActivityById(long id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT id, start_time, activity_desc, activity_type FROM activities WHERE id = ?")) {

            pstmt.setLong(1, id);
            List<Activity> result = selectActivityByPreparedStatement(pstmt);
            if (result.isEmpty()) {
                throw new IllegalArgumentException("Activity not found ");
            }
            return result.get(0);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect " + sqle.getMessage(), sqle);
        }

    }

    public List<Activity> listActivities() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT * FROM activities")) {

            List<Activity> result = selectActivityByPreparedStatement(pstmt);
            if (result.isEmpty()) {
                throw new IllegalArgumentException("Activity not found ");
            }
            return result;

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect " + sqle.getMessage(), sqle);
        }

    }

    private List<Activity> selectActivityByPreparedStatement(PreparedStatement pstmt) {
        try (ResultSet rs = pstmt.executeQuery()) {

            List<Activity> result = new ArrayList<>();
            while (rs.next()) {
                long id = rs.getLong("id");
                LocalDateTime ldt = rs.getTimestamp("start_time").toLocalDateTime();
                String desc = rs.getString("activity_desc");
                Type type = Type.valueOf(rs.getString("activity_type"));
                result.add(new Activity(id, ldt, desc, type));
            }
            return result;

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not select from table " + sqle.getMessage(), sqle);
        }
    }
}
