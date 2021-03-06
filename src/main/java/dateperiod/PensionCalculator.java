package dateperiod;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PensionCalculator {
    private List<Period> periods = new ArrayList<>();

    public void addEmploymentPeriod(Period period) {
        periods.add(period);
    }

    public Period sumEmploymentPeriods() {
        Period result = periods.stream().reduce(Period.ZERO, Period::plus, Period::plus).normalized();
        return fullyNormalized(result);
    }

    public Period modifyByDays(Period period, int days) {
        return fullyNormalized(period.plusDays(days));
    }

    public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate) {
        if (fromDate == null || toDate == null) {
            throw new NullPointerException("Null parameters are not allowed!");
        }
        return Period.between(fromDate, toDate).normalized();
    }

    public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern) {
        if (fromDate.isBlank()) {
            throw new IllegalArgumentException("Empty from date string, cannot use: " + fromDate);
        }
        if (toDate.isBlank()) {
            throw new IllegalArgumentException("Empty to date string, cannot use: " + toDate);
        }
        if (pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + pattern);
        }
        LocalDate from = LocalDate.parse(fromDate, DateTimeFormatter.ofPattern(pattern));
        LocalDate to = LocalDate.parse(toDate, DateTimeFormatter.ofPattern(pattern));
        return Period.between(from, to).normalized();
    }

    public int calculateTotalDays(Period period) {
        return period.getYears() * 365
                + period.getMonths() * 30
                + period.getDays();
    }

    private Period fullyNormalized(Period period) {
        int overflow = period.getDays() / 30;
        Period plusPeriod = Period.of(0, overflow, -overflow * 30);
        return period.plus(plusPeriod).normalized();
    }
}
