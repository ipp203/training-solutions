package db_activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;

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

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        atDAO = new ActivityTrackerDAO(dataSource);
        ActivityTrackerMain atm = new ActivityTrackerMain();
        activities = atm.createActivities();

    }

    @Test
    void testSaveActivity() {

        atDAO.saveActivity(activities[0]);

        assertEquals(1, atDAO.listActivities().size());
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
}