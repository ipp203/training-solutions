package week07.d03;

public class Date {
    private final int year;
    private final int month;
    private final int day;

    private Date(int year, int month, int day) {
        if (!isValidMonth(month)) {
            throw new IllegalArgumentException("Month is not valid " + month);
        }
        if (!isValidDay(day)) {
            throw new IllegalArgumentException("Day is not valid " + day);
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public static Date of(int year, int month, int day) {
        return new Date(year, month, day);
    }

    public Date withYear(int year) {
        return new Date(year, this.month, this.day);
    }

    public Date withMonth(int month) {
        if (!isValidMonth(month)) {
            throw new IllegalArgumentException("Month is not valid " + month);
        }
        return new Date(this.year, month, this.day);
    }

    public Date withDay(int day) {
        if (!isValidDay(day)) {
            throw new IllegalArgumentException("Day is not valid " + day);
        }
        return new Date(this.year, this.month, day);
    }

    private boolean isValidMonth(int month) {
        return 0 < month && month < 13;
    }

    private boolean isValidDay(int day) {
        return 0 < day && day < 32;
    }
}
