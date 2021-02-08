package week15.d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BitcoinsTest {

    @Test
    void findMaxProfit() {
        Bitcoins b = new Bitcoins();
        BitcoinProfit bf = b.findMaxProfit(Arrays.asList(100,120,40,70,200,30,50));
        System.out.println(bf);
    }
}