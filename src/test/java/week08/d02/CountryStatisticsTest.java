package week08.d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryStatisticsTest {

    @Test
    void loadData() {
        CountryStatistics cs = new CountryStatistics();

        cs.readCountryData("countries.txt");
        assertEquals(11, cs.getCountryData().size());

    }

    @Test
    void getLargestPopulation() {
        CountryStatistics cs = new CountryStatistics();

        cs.readCountryData("countries.txt");

        assertEquals(79, cs.maxPopulation().getPopulation());
    }

}