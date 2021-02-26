package db_activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTrackerDAOTest {

    ActivityTrackerDAO atDAO;
    Activity[] activities;

    @BeforeEach
    void init() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode = true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not create datasource " + sqle.getMessage(), sqle);
        }

        Flyway flyway = Flyway.configure().locations("db/migration/activitytracker").dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        atDAO = new ActivityTrackerDAO(dataSource);
        activities = createActivities();

    }

    public Activity[] createActivities() {
        TrackPoint[][] trackPoints = new TrackPoint[][]
                {{
                        new TrackPoint(LocalDateTime.of(2020, 6, 23, 12, 12, 12), 47.475148, 19.027053),
                        new TrackPoint(LocalDateTime.of(2020, 6, 23, 19, 30, 0), 48.092720, 20.306210)
                }, {
                        new TrackPoint(LocalDateTime.of(2020, 7, 23, 9, 12, 12), 47.475148, 19.027053),
                        new TrackPoint(LocalDateTime.of(2020, 7, 23, 17, 30, 0), 46.888853, 17.891791)
                }, {
                        new TrackPoint(LocalDateTime.of(2020, 8, 23, 15, 0, 0), 47.498293, 19.040346),
                        new TrackPoint(LocalDateTime.of(2020, 8, 23, 17, 30, 0), 47.498293, 19.040346)
                }, {
                        new TrackPoint(LocalDateTime.of(2020, 9, 23, 5, 0, 0), 46.999573, 18.168028),
                        new TrackPoint(LocalDateTime.of(2020, 9, 23, 15, 0, 0), 46.724727, 17.2410806),
                        new TrackPoint(LocalDateTime.of(2020, 9, 23, 23, 30, 0), 146.999573, 18.168028)
                }};

        Activity[] act = new Activity[4];
        act[0] = new Activity(
                LocalDateTime.of(2020, 6, 23, 9, 12),
                "Biking to Balaton",
                Type.BIKING);
        act[1] = new Activity(
                LocalDateTime.of(2020, 7, 23, 9, 12),
                "Hiking to Tihany",
                Type.HIKING);
        act[2] = new Activity(
                LocalDateTime.of(2020, 8, 23, 9, 12),
                "Playing basketball against Siófok",
                Type.BASKETBALL);
        act[3] = new Activity(
                LocalDateTime.of(2020, 9, 23, 9, 12),
                "Running around Balaton",
                Type.RUNNING);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < trackPoints[i].length; j++) {
                act[i].addTrackPoint(trackPoints[i][j]);
            }
        }

        return act;
    }

    @Test
    void testSaveActivity() {

        atDAO.saveActivity(activities[0]);

        assertEquals(1, atDAO.listActivities().size());
    }

    @Test
    void testSaveActivities() {

        List<Activity> result = atDAO.saveActivities(Arrays.asList(activities));

        assertTrue(result.get(0).getId() > 0);
    }


    @Test
    void testSaveActivityWithGeneratedId() {

        Activity activity = atDAO.saveActivity(activities[0]);

        assertEquals(activity, atDAO.findActivityById(activity.getId()));
    }

    @Test
    void testFindActivityById() {

        for (Activity activity : activities) {
            atDAO.saveActivity(activity);
        }

        assertEquals(activities[0].getType(), atDAO.findActivityById(1).getType());
    }

    @Test
    void testListActivities() {
        for (Activity activity : activities) {
            atDAO.saveActivity(activity);
        }

        assertEquals(4, atDAO.listActivities().size());
    }

    @Test
    void testSaveActivityWithTrackPoint() {
        Activity activity = atDAO.saveActivity(activities[0]);

        Activity result = atDAO.findActivityById(activity.getId());

        assertEquals(activity, result);
    }

    @Test
    void testSaveActivitiesWithTrackPoint() {
        List<Activity> activityList = atDAO.saveActivities(Arrays.asList(activities));

        List<Activity> result = atDAO.listActivities();

        assertEquals(activityList.get(0).getTrackPoints().size(), result.get(0).getTrackPoints().size());
        assertEquals(0, result.get(3).getTrackPoints().size());
    }


}