package datenewtypes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;

public class FamilyBirthdays {
    private List<LocalDate> birthdays;

    public FamilyBirthdays(LocalDate... birthdays) {
        this.birthdays = Arrays.asList(birthdays);
    }

    public boolean isFamilyBirthday(TemporalAccessor date) {
        LocalDate date1 = (LocalDate) date;
        for (LocalDate ld : birthdays) {
            if (ld.getMonth().equals(date1.getMonth())
                    && ld.getDayOfMonth() == date1.getDayOfMonth()) {
                return true;
            }
        }
        return false;
    }

    public int nextFamilyBirthDay(TemporalAccessor date) {
        if (isFamilyBirthday(date)) {
            return 0;
        }

        long min = Long.MAX_VALUE;
        for (LocalDate ld : birthdays) {
            LocalDate date1 = ((LocalDate) date).withYear(ld.getYear());
            if (ld.isAfter(date1)) {
                long diff = ChronoUnit.DAYS.between(date1, ld);
                if (min > diff) {
                    min = diff;
                }
            }else{
               date1 = date1.minusYears(1);
                long diff = ChronoUnit.DAYS.between(date1, ld);
                if (min > diff) {
                    min = diff;
                }
            }
        }
        return (int) min;
    }


}
