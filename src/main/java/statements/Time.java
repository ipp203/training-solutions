package statements;

public class Time {
    int hours, minutes, seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public int getInMinutes(){
        return hours * 60 + minutes;
    }

    public int getInSeconds(){
        return hours * 60 * 60 + minutes * 60 + seconds;
    }

    public boolean earlierThan(Time time){
        return this.getInSeconds() < time.getInSeconds();
    }

    public String toString(){
        return hours + ":" + minutes + ":" + seconds;
    }
}
