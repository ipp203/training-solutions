package db_activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ActivityTrackerMain {

    private static MariaDbDataSource getDataSource() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode = true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not create datasource", sqle);
        }
        return dataSource;
    }

    public static void main(String[] args) {
//        ActivityTrackerMain atm = new ActivityTrackerMain();
//        Activity[] activities = atm.createActivities();
//
//        ActivityTrackerDAO activityTrackerDAO =
//                new ActivityTrackerDAO(ActivityTrackerMain.getDataSource());
//
//        for (Activity act : activities) {
//            activityTrackerDAO.saveActivity(act);
//        }
//
//        System.out.println(activityTrackerDAO.findActivityById(1));
//        System.out.println(activityTrackerDAO.listActivities());


    }
}
