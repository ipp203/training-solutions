package week15.d05;

import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CovidDataSumTest {
    @Test
    void testCovidDataSum() {
        CovidDataSum cds = new CovidDataSum();
        List<Country> result = cds.getThreeMostCasesPerPopulation(CovidDataSumTest.class.getResourceAsStream("data.csv"));

        assertEquals("Andorra", result.get(0).getName());
        assertEquals("Gibraltar", result.get(1).getName());
        assertEquals("Montenegro", result.get(2).getName());
    }
}