package exceptionclass.course;

public class SimpleTime {
    private int hour, minute;

    public SimpleTime(int hour, int minute) {
        hourValidator(hour);
        minuteValidator(minute);
        this.hour = hour;
        this.minute = minute;
    }

    public SimpleTime(String time) {
        if (time == null) {
            throw new InvalidTimeException("Time is null");
        }
        String[] parts = time.split(":");
        if (parts.length != 2) {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        try {
            int hour = Integer.parseInt(parts[0]);
            hourValidator(hour);
            this.hour = hour;

            int minute = Integer.parseInt(parts[1]);
            minuteValidator(minute);
            this.minute = minute;

        } catch (NumberFormatException nfe) {
            throw new InvalidTimeException("Time is not hh:mm");
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }

    private void hourValidator(int hour) {
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
    }

    private void minuteValidator(int minute) {
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
    }
}
