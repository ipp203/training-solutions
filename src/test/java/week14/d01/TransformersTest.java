package week14.d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransformersTest {

    @Test
    void testMap() {
        Transformers transformers = new Transformers();
        List<String> list = Arrays.asList("alma", "banan", "narancs");
        List<Integer> r = transformers.map(list, String::length);

        assertArrayEquals(new Integer[]{4, 5, 7}, r.toArray());
    }

    @Test
    void testReduce() {
        Transformers transformers = new Transformers();
        List<String> list = Arrays.asList("alma", "banan", "narancs");
        String r = transformers.reduce(list, "", String::concat);

        assertEquals("almabanannarancs", r);
    }
}