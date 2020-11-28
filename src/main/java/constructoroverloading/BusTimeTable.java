package constructoroverloading;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {
    List<SimpleTime> timeTable;

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        timeTable = new ArrayList<>();
        for (int i = firstHour; i <= lastHour; i++) {
            timeTable.add(new SimpleTime(i, everyMinute));
        }
    }

    public List<SimpleTime> getTimeTable() {
        return timeTable;
    }

    public SimpleTime nextBus(SimpleTime actual) {
        for (SimpleTime time : timeTable) {
            if (actual.difference(time) < 0) {
                return time;
            }
        }
        throw new IllegalStateException("No more buses today!");
    }

    public SimpleTime firstBusToday() {
        int j = 0;
        int minim = Integer.MAX_VALUE;
        for (int i = 0; i < timeTable.size(); i++) {
            int minutes = timeTable.get(i).getHours() * 60 + timeTable.get(i).getMinutes();
            if (minutes < minim) {
                j = i;
                minim = minutes;
            }
        }
        return timeTable.get(j);
    }
}
