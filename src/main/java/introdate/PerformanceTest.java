package introdate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class PerformanceTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2019, Month.JANUARY,22);
        LocalTime startTime = LocalTime.of(20,15,0);
        LocalTime endTime = LocalTime.of(21,5,0);

        Performance performance = new Performance(date,startTime,endTime,"Metallica");
        System.out.println(performance.getInfo());
    }
}
