package week06.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedSumTest {
    @Test
    public void testSeparatedSum() {
        SeparatedSum ss = new SeparatedSum();
        String s = "1,256;-3,14;0,002;-1,86;3,742";
        assertTrue(Math.abs(ss.sum(s).getPositiveSum() - 5.0) < 1e-8);
        assertTrue(Math.abs(ss.sum(s).getNegativeSum() + 5.0) < 1e-8);
        assertEquals(5.0, ss.sum(s).getPositiveSum(), 1e-8);
        assertEquals(-5.0, ss.sum(s).getNegativeSum(), 1e-8);

    }
}