package week07.d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void OfTest() {
        Date date = Date.of(2020, 12, 9);

        assertEquals(2020, date.getYear());
    }

    @Test
    void withYearTest() {
        Date date = Date.of(2020, 12, 9);
        Date date1 = date.withYear(2019);
        assertEquals(2019, date1.getYear());
        assertEquals(12, date1.getMonth());
    }

    @Test
    void withMonthTest() {
        Date date = Date.of(2020, 12, 9);

        Date date1 = date.withMonth(11);
        assertEquals(2020, date1.getYear());
        assertEquals(11, date1.getMonth());

    }

    @Test
    void withDayTest() {
        Date date = Date.of(2020, 12, 9);

        Date date1 = date.withDay(19);
        assertEquals(2020, date1.getYear());
        assertEquals(19, date1.getDay());

    }

    @Test
    void exceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> Date.of(2020, 13, 12));

    }
}