package week10.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HikingFileTest {

    @Test
    void testElevation() {
        HikingFile hf = new HikingFile();
        ElevationData ed = hf.getElevation(HikingFileTest.class.getResourceAsStream("GPSData.txt"));

        assertEquals(40, ed.getInc());
        assertEquals(30, ed.getDec());
    }

}