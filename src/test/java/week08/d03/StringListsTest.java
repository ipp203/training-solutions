package week08.d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListsTest {
    @Test
    void testWords() {
        StringLists sl = new StringLists();
        List<String> result = sl.shortestWords(Arrays.asList("aaa", "aa", "bb", "cccc", "dd"));


        assertArrayEquals(new String[]{"aa", "bb", "dd"}, result.toArray());
    }

}