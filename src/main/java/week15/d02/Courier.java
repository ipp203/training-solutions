package week15.d02;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Courier {
    private LocalDate date;
    private LocalTime time;
    private String id;
    private Address address;


    public static Courier createByDateString(String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate myDate = LocalDate.parse(date, format);
        return createWithDate(myDate);
    }

    public static Courier createWithDate(LocalDate date) {
        Courier result = new Courier();
        result.date = date;
        return result;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public void setTime(String time) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        this.time = LocalTime.parse(time, format);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String[] address) {
        this.address = new Address(address[0],address[1],address[2]);
    }

    @Override
    public String toString() {
        return id + ": address=" + address + " date=" + date + ' ' + time;
    }
}
