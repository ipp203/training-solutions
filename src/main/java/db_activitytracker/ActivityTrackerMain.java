package db_activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;

public class ActivityTrackerMain {

    public Activity[] createActivities() {
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
        return act;
    }

    private static MariaDbDataSource getDataSource() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode = true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not create datasource " + sqle.getMessage(), sqle);
        }
        return dataSource;
    }

    public static void main(String[] args) {
        ActivityTrackerMain atm = new ActivityTrackerMain();
        Activity[] activities = atm.createActivities();

        ActivityTrackerDAO activityTrackerDAO =
                new ActivityTrackerDAO(ActivityTrackerMain.getDataSource());

        for (Activity act : activities) {
            activityTrackerDAO.saveActivity(act);
        }

        System.out.println(activityTrackerDAO.findActivityById(1));
        System.out.println(activityTrackerDAO.listActivities());


    }
}
