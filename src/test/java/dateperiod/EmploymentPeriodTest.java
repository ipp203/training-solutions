package dateperiod;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EmploymentPeriodTest {
    EmploymentPeriod eperiod;

    @BeforeEach
    void init(){
        eperiod=new EmploymentPeriod(Arrays.asList(
                Period.of(1,1,1),
                Period.of(10,13,45)
        ));
    }

    @Test
    void testSumEmploymentPeriods() {
        assertEquals("P12Y3M16D",eperiod.sumEmploymentPeriods().toString());
    }


    @Test
    void testAddEmploymentPeriod() {
        eperiod.addEmploymentPeriod(Period.of(1,1,1));
        assertEquals("P13Y4M17D",eperiod.sumEmploymentPeriods().toString());
    }

    @Test
    void testModifyByDays() {
        Period input = Period.of(1,1,1);
        Period output = eperiod.modifyByDays(input,93);
        assertEquals("P3M3D",output.minus(input).toString());
    }

    @Test
    void testModifyByDaysWithNull() {
        assertThrows(NullPointerException.class,
                ()->eperiod.modifyByDays(null,3),
                "Period is null");
    }

    @Test
    void testGetPeriodBetweenDates() {
        Period result = eperiod.getPeriodBetweenDates(
                LocalDate.of(2001,10,30),
                LocalDate.of(2002,9,3));
        assertEquals("P10M4D",result.toString());
    }

    @Test
    void testGetPeriodBetweenDatesStrings() {
        Period result = eperiod.getPeriodBetweenDates(
                "2001.10.30","2002.09.03","yyyy.MM.dd");
        assertEquals("P10M4D",result.toString());
    }

    @Test
    void testCalculateTotalDays() {
        assertEquals(396,
                eperiod.calculateTotalDays(Period.of(1,1,1)));
    }
}