package datenewtypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Rendezvous {
    private LocalTime time;

    public Rendezvous(String time, String pattern) {
        isEmptyTime(time);
        isEmptyPattern(pattern);

        DateTimeFormatter f = DateTimeFormatter.ofPattern(pattern);
        try {
            this.time = LocalTime.parse(time, f);
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Illegal time string: " + time, dtpe);
        }

    }

    public Rendezvous(int hour, int minute) {
        time = LocalTime.of(hour, minute);
    }

    public String toString(String pattern) {
        isEmptyPattern(pattern);
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    public int countMinutesLeft(LocalTime time) {
        if (this.time.isBefore(time)) {
            throw new MissedOpportunityException("Too late!");
        }
        return (int)ChronoUnit.MINUTES.between(time,this.time);
    }

    public void pushLater(int hour, int minute) {
        time = ChronoUnit.HOURS.addTo(time, hour);
        time = ChronoUnit.MINUTES.addTo(time, minute);
    }

    public void pullEarlier(int hour, int minute) {
        time = time.minusHours(hour).minusMinutes(minute);
    }

    private void isEmptyTime(String str) {
        if (str.isBlank()) {
            throw new IllegalArgumentException("Illegal time string: " + str);
        }
    }

    private void isEmptyPattern(String str) {
        if (str.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string!");
        }
    }
}
