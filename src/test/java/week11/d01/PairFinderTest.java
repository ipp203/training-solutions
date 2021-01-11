package week11.d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void findPairsTest() {
        PairFinder pf = new PairFinder();
        int result = pf.findPairs(new int[]{1, 1});
        assertEquals(1, result);

        result = pf.findPairs(new int[]{1, 1, 1});
        assertEquals(1, result);

        result = pf.findPairs(new int[]{1, 1, 1, 1});
        assertEquals(2, result);

        result = pf.findPairs(new int[]{7, 1, 5, 7, 3, 3, 5, 7, 6, 7});
        assertEquals(4, result);


    }
}