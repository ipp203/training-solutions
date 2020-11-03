package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class Performance {
    private LocalDate date;
    private LocalTime startTime,endTime;
    private String artist;

    public Performance(LocalDate date, LocalTime startTime, LocalTime endTime, String artist) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.artist = artist;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getArtist() {
        return artist;
    }

    public String getInfo(){
        return artist + ": " + date + " " + startTime + " - " + endTime;
    }
}
