package week06d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {
    @Test
    public void testSeries() {
        Series series = new Series();
        assertEquals(SeriesType.NOVEKVO, series.calculateSeriesType(Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals(SeriesType.CSOKKENO, series.calculateSeriesType(Arrays.asList(5, 4, 3, 2, 1)));
        assertEquals(SeriesType.OSSZE_VISSZA, series.calculateSeriesType(Arrays.asList(5, 2, 3, 2, 1)));
    }

}