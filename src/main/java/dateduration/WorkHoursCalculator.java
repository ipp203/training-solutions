package dateduration;

import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class WorkHoursCalculator {
    private List<Duration> durations = new ArrayList<>();

    public void addWorkTime(Duration duration) {
        durations.add(duration);
    }

    public void addWorkTime(int days, int hours, int minutes) {
        Duration d = Duration.ofDays(days);
        d = d.plusHours(hours);
        d = d.plusMinutes(minutes);
        durations.add(d);
    }

    public void addWorkTime(String durationString) {
        if (durationString == null || durationString.isBlank()) {
            throw new IllegalArgumentException("Parameter must not be empty!");
        }
        try {
            Duration d = Duration.parse(durationString);
            durations.add(d);
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Parameter must match PnDTnHnM pattern, but found: " + durationString, dtpe);
        }
    }

    public int calculateWorkHours() {
        return (int) durations.stream()
                .reduce(Duration.ZERO, Duration::plus)
                .toHours();
    }

    public Duration getWorkDuration() {
        return durations.stream()
                .reduce(Duration.ZERO, Duration::plus);
    }

    public String toString() {
        Duration d = getWorkDuration();
        int days = (int) d.toDays();
        int hours = (int) (d.toHours() - Duration.ofDays(days).toHours());
        int minutes = (int) (d.toMinutes() - Duration.ofDays(days).plusHours(hours).toMinutes());
        return "Days: " + days + ", hours: " + hours + ", minutes: " + minutes;
    }
}
