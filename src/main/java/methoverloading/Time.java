package methoverloading;

public class Time {
    private int hours, minutes, seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public Time(int hours) {
        this.hours = hours;
    }

    public Time(Time time) {
        this.hours = time.hours;
        this.minutes = time.minutes;
        this.seconds = time.seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public boolean isEqual(Time time) {
        return intoSeconds(hours, minutes, seconds) == intoSeconds(time.hours, time.minutes, time.seconds);
    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        return intoSeconds(this.hours, this.minutes, this.seconds) == intoSeconds(hours, minutes, seconds);
    }

    public boolean isEarlier(Time time) {
        return intoSeconds(hours, minutes, seconds) < intoSeconds(time.hours, time.minutes, time.seconds);
    }

    public boolean isEarlier(int hours, int minutes, int seconds) {
        return intoSeconds(this.hours, this.minutes, this.seconds) < intoSeconds(hours, minutes, seconds);
    }

    private int intoSeconds(int hours, int minutes, int seconds) {
        return ((hours * 60) + minutes) * 60 + seconds;
    }
}
