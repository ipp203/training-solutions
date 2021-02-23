package db_activitytracker;

import java.time.LocalDateTime;

public class Activity {
    private long id;
    private LocalDateTime startTime;
    private String desc;
    private Type type;

    public Activity(long id, LocalDateTime startTime, String desc, Type type) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public Activity(LocalDateTime startTime, String desc, Type type) {
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return id + ". startTime=" + startTime +
                ", desc=" + desc +
                ", type=" + type;
    }
}
