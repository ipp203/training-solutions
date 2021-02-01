package datenewtypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;


public class DateOfBirth {
    private LocalDate dateOfBirth;

    public DateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public DateOfBirth(String date, String format, Locale locale) {
        if (format.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + format);
        }
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        dateOfBirth = LocalDate.parse(date, DateTimeFormatter.ofPattern(format, locale));
    }

    public DateOfBirth(String date, String format) {
        this(date, format, Locale.ENGLISH);
    }

    public DateOfBirth(int year, int month, int day) {
        dateOfBirth = LocalDate.of(year, month, day);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }


    public String toString(String format) {
        if (format.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + format);
        }
        return dateOfBirth.format(DateTimeFormatter.ofPattern(format));
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        return dateOfBirth.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);

    }

    public String findDayOfWeekForBirthDate(Locale locale, LocalDate date) {
        DateOfBirth db = new DateOfBirth(date);
        return db.findDayOfWeekForBirthDate(locale);
    }

    public int countDaysSinceBirth(LocalDate date) {
        if (date.isBefore(dateOfBirth)) {
            throw new IllegalStateException("Birthdate is in the future!");
        }
        return (int) ChronoUnit.DAYS.between(dateOfBirth, date);
    }

    public int countDaysBetween(DateOfBirth date) {
        if (date.getDateOfBirth().isBefore(dateOfBirth)) {
            throw new IllegalStateException("Birthdate is in the future!");
        }
        return (int) ChronoUnit.DAYS.between(dateOfBirth, date.getDateOfBirth());
    }
}
