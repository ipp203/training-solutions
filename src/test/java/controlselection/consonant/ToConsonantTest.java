package controlselection.consonant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToConsonantTest {
    @Test
    void testCreate() {
        //Given
        ToConsonant toConsonant = new ToConsonant();
        //Then
        assertEquals('b', toConsonant.charToConsonant('a'));
        assertEquals('B', toConsonant.charToConsonant('A'));
        assertEquals('c', toConsonant.charToConsonant('c'));
    }
}
