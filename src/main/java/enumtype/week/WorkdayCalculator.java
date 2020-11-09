package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {

    private Day nextDay(Day day){
        int nextNumb = (day.ordinal() + 1) % Day.values().length;
        return Day.values()[nextNumb];
    }

    public List<DayType> dayTypes(Day firstDay, int numberOfDays){
        List<DayType> dayTypes = new ArrayList<>();
        Day day = firstDay;
        for (int i = 0; i < numberOfDays; i++) {
            dayTypes.add(day.getDayType());
            day = nextDay(day);
        }
        return dayTypes;
    }
}
