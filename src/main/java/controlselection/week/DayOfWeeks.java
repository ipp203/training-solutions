package controlselection.week;

public class DayOfWeeks {
    public String dayOfWeeks(String day){
        switch (day.toLowerCase()){
            case "monday":
                return "Start of the week.";
            case "tuesday","wednesday","thursday":
                return "Middle of the week.";
            case "friday":
                return "Near to weekend.";
            case "saturday","sunday":
                return "Weekend.";
            default: throw new IllegalArgumentException("Invalid day: " + day);
        }
    }
}
