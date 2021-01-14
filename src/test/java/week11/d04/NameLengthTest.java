package week11.d04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameLengthTest {

    @Test
    void getLengthsTest() {
        NameLength nameLength = new NameLength();
        List<Integer> result = nameLength.getLengths(Arrays.asList("Joe", "Jack", "Jane", "Jake", "George", "William"));
        Collections.sort(result);

        assertEquals(2, result.size());
        assertArrayEquals(new Integer[]{3, 4}, result.toArray());
    }

    @Test
    void getLengthsTestWithEmptyParameter() {
        NameLength nameLength = new NameLength();
        List<Integer> result = nameLength.getLengths(new ArrayList<>());
        assertEquals(0, result.size());

        result = nameLength.getLengths(Arrays.asList("Joe", "Jack", "Jane", "Jake", "George", "", null));
        Collections.sort(result);

        assertEquals(2, result.size());
        assertArrayEquals(new Integer[]{3, 4}, result.toArray());
    }
}