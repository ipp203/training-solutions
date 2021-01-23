package lambdaintro;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;

public class FamilyBirthdays {
    private List<LocalDate> birthdays;

    public FamilyBirthdays(LocalDate... dates) {
        if (dates == null || dates.length == 0) {
            throw new IllegalArgumentException("No any date");
        }
        birthdays = Arrays.asList(dates);
    }

    public boolean isFamilyBirthday(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);

        for (LocalDate birthday : birthdays) {
            LocalDate localDate = LocalDate.of(birthday.getYear(), month, day);
            if (birthday.equals(localDate)) {
                return true;
            }
        }
        return false;
    }

    public int nextFamilyBirthDay(TemporalAccessor date) {
        int year = date.get(ChronoField.YEAR);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);
        LocalDate localDate = LocalDate.of(year, month, day);

        long min = Long.MAX_VALUE;
        for (LocalDate birthday : birthdays) {
            LocalDate tempBirthday = birthday.withYear(year);
            if (tempBirthday.isBefore(localDate)) {
                tempBirthday = tempBirthday.plusYears(1);
            }
            long diff = ChronoUnit.DAYS.between(localDate, tempBirthday);
            if (min > diff) {
                min = diff;
            }
        }
        return (int) min;
    }
}
