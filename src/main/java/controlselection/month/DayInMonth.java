package controlselection.month;

public class DayInMonth {
    public int numberOfDays(int year, String month) {
        switch (month.toLowerCase()) {
            case "február":
                if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                    return 29;
                }
                else {
                    return 28;
                }
            case "január", "március", "május", "július", "augusztus", "október", "december":
                return 31;
            case "április", "június", "szeptember", "november":
                return 30;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
    }
}
