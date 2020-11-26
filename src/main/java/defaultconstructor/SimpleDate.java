package defaultconstructor;

public class SimpleDate {
    private int year, month, day;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDate(int year, int month, int day) {
        if (isCorrect(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " +
                    year + ", " + month + ", " + day);
        }
    }

    private boolean isCorrect(int year, int month, int day) {
        return (year >= 1900) &&
                (month > 0 && month <= 12) &&
                (day > 0 && day <= calculateMonthLength(year, month));
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }

    private int calculateMonthLength(int year, int month) {
        int result = 0;
        switch (month) {
            case 1, 3, 5, 8, 10, 12: {
                result = 31;
                break;
            }
            case 4, 6, 7, 9, 11: {
                result = 30;
                break;
            }
            case 2: {
                if (isLeapYear(year)) {
                    result = 29;
                } else {
                    result = 28;
                }
                break;
            }
        }
        return result;
    }
}
