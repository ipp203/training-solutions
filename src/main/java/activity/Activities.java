package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {
    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public List<Report> distancesByTypes() {
        List<Report> reports = new ArrayList<>();
        for (ActivityType activityType : ActivityType.values()) {
            reports.add(new Report(activityType, distanceByType(activityType)));
        }
        return reports;
    }

    public int numberOfTrackActivities() {
        int result = 0;
        for (Activity activity : activities) {
            if (activity instanceof ActivityWithTrack) {
                result++;
            }
        }
        return result;
    }

    public int numberOfWithoutTrackActivities() {
        int result = 0;
        for (Activity activity : activities) {
            if (activity instanceof ActivityWithoutTrack) {
                result++;
            }
        }
        return result;
    }

    private double distanceByType(ActivityType activityType) {
        double result = 0.0;
        for (Activity activity : activities) {
            if (activity.getType() == activityType) {
                result += activity.getDistance();
            }
        }
        return result;
    }


}
