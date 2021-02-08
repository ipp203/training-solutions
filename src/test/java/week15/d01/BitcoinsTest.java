package week15.d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitcoinsTest {

    @Test
    void findMaxProfit() {
        Bitcoins b = new Bitcoins();
        BitcoinProfit bf = b.findMaxProfit(Arrays.asList(100,120,40,70,200,30,50));
        assertEquals(3,bf.getBuyDay());
        assertEquals(5,bf.getSaleDay());
        assertEquals(160,bf.getProfit());
    }
}