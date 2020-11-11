package controlselection.week;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayOfWeeksTest {
    @Test
    void testCreate(){
        //Given
        DayOfWeeks dayOfWeeks = new DayOfWeeks();
        //Then
        assertEquals("Start of the week.",dayOfWeeks.dayOfWeeks("monday"));
        assertEquals("Middle of the week.",dayOfWeeks.dayOfWeeks("wednesday"));
        assertEquals("Near to weekend.",dayOfWeeks.dayOfWeeks("FRiday"));
        assertEquals("Weekend.",dayOfWeeks.dayOfWeeks("Sunday"));
    }
}
