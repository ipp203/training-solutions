package week06d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {
    private Series series;

    @BeforeEach
    void init() {
        series = new Series();
    }

    @Test
    public void testInc() {

        assertEquals(Series.SeriesType.INC, series.calculateSeriesType(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void testDec() {

        assertEquals(Series.SeriesType.DEC, series.calculateSeriesType(Arrays.asList(5, 4, 3, 2, 1)));
    }

    @Test
    public void testRandom() {

        assertEquals(Series.SeriesType.RANDOM, series.calculateSeriesType(Arrays.asList(5, 2, 3, 2, 1)));
    }


}