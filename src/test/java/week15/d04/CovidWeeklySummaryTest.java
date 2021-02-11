package week15.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CovidWeeklySummaryTest {

    @Test
    void testSumHungarianWeeklyCases() {
        CovidWeeklySummary cws = new CovidWeeklySummary();
        String result = cws.sumHungarianWeeklyCases(CovidWeeklySummaryTest.class.getResourceAsStream("data.csv"));
        assertEquals("2020-48", result);
    }
}