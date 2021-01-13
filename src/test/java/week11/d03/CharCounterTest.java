package week11.d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {

    @Test
    void countCharsTest() {
        CharCounter cc = new CharCounter();
        int result = cc.countChars(new String[]{"abcde", "bcdef", "cdefg", "defgh"});
        assertEquals(2, result);

    }

    @Test
    void countCharsWithEmptyString() {
        CharCounter cc = new CharCounter();
        int result = cc.countChars(new String[]{"abcde", "bcdef", "cdefg", ""});
        assertEquals(0, result);

        result = cc.countChars(new String[]{});
        assertEquals(0, result);
    }
}