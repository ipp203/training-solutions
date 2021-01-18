package week12.d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GoodsPackerTest {
    @Test
    void packGoodsTest() {
        //Given
        GoodsPacker goodsPacker = new GoodsPacker();
        //When
        int[][] types = {{7, 160}, {3, 90}, {2, 15}};
        int maxPrice = goodsPacker.packGoods(types, 20);
        //Then
        assertEquals(555, maxPrice);

        maxPrice = goodsPacker.packGoods(types, 21);
        //Then
        assertEquals(7 * 90, maxPrice);
    }
}