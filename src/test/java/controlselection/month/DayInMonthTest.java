package controlselection.month;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayInMonthTest {
    @Test
    void testCreate(){
        //Given
        DayInMonth dayInMonth = new DayInMonth();
        //Then
        assertEquals(31,dayInMonth.numberOfDays(2000,"Január"));
        assertEquals(28,dayInMonth.numberOfDays(2019,"február"));
        assertEquals(29,dayInMonth.numberOfDays(2020,"február"));
        assertEquals(28,dayInMonth.numberOfDays(2100,"február"));
        assertEquals(29,dayInMonth.numberOfDays(2400,"február"));
        assertEquals(30,dayInMonth.numberOfDays(2000,"november"));
        //assertEquals(31,dayInMonth.numberOfDays(2000,"Januar"));

    }
}
