package week15.d04;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCounterTest {

    @Test
    void countChar() {
        CharacterCounter cc = new CharacterCounter();
        Map<CharType, Long> result = cc.countChar("src/test/resources/week15/d04/text.txt");
        // Map<CharType, Long> result = cc.countChar("text.txt");
        Map<CharType, Long> control = Map.of(
                CharType.VOWEL, 873L,
                CharType.OTHER, 246L,
                CharType.CONSONANT, 1392L);
        assertEquals(control, result);
    }
}