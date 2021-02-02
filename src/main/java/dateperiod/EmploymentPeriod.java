package dateperiod;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmploymentPeriod {
    private List<Period> periods;

    public EmploymentPeriod(List<Period> periods) {
        this.periods = new ArrayList<>(periods);
    }

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
            throw new NullPointerException("Date is null");
        }
        return Period.between(fromDate, toDate).normalized();
    }

    public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern) {
        if (fromDate.isBlank() || toDate.isBlank()) {
            throw new IllegalArgumentException("Date is blank");
        }
        if (pattern.isBlank()) {
            throw new IllegalArgumentException("Pattern is blank");
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
