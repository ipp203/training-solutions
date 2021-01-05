package week10.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelTest {

    @Test
    void getStopWithMax() {
        Travel travel = new Travel();
        int stop = travel.getStopWithMax(this.getClass().getResourceAsStream("utasadat.txt"));

        assertEquals(22, stop);
    }
}