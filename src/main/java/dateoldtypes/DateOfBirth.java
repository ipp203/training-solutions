package dateoldtypes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateOfBirth {

    public static final String ILLEGAL_DATE_STRING = "Illegal date string, cannot parse: ";
    public static final String ILLEGAL_PATTERN_STRING = "Illegal pattern string, cannot use: ";

    private Date dateOfBirth;

    public DateOfBirth(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.setLenient(false);
        c.set(year, month - 1, day);
        dateOfBirth = c.getTime();
    }

    public DateOfBirth(String dateString, String pattern, Locale locale) {
        if (isEmpty(dateString)) {
            throw new IllegalArgumentException(ILLEGAL_DATE_STRING + dateString);
        }
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException(ILLEGAL_PATTERN_STRING + pattern);
        }
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        DateFormat df = new SimpleDateFormat(pattern, locale);
        setDateOfBirth(dateString, df);
    }

    public DateOfBirth(String dateString, String pattern) {
        if (isEmpty(dateString)) {
            throw new IllegalArgumentException(ILLEGAL_DATE_STRING + dateString);
        }
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException(ILLEGAL_PATTERN_STRING + pattern);
        }
        DateFormat df = new SimpleDateFormat(pattern);
        setDateOfBirth(dateString, df);
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }

        Calendar c = Calendar.getInstance();
        c.setTime(dateOfBirth);
        return c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
    }

    public String toString(String pattern) {
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException(ILLEGAL_PATTERN_STRING + pattern);
        }
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(dateOfBirth);
    }

    public boolean isWeekDay() {
        Calendar c = Calendar.getInstance();
        c.setTime(dateOfBirth);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek < Calendar.SATURDAY && dayOfWeek >= Calendar.MONDAY;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    private void setDateOfBirth(String dateString, DateFormat dateFormat) {
        try {
            dateOfBirth = dateFormat.parse(dateString);
        } catch (ParseException pe) {
            throw new IllegalStateException("4");
        }
    }
}
