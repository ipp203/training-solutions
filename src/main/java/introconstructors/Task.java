package introconstructors;

import java.time.LocalDateTime;

public class Task {
    private String title, description;
    private LocalDateTime startLocalDate;
    private int duration;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartLocalDate() {
        return startLocalDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void start() {
        startLocalDate = LocalDateTime.now();
    }
}
