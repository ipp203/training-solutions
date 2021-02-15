package week16.d01.VowelsFilter;

import org.junit.jupiter.api.Test;
import week16.d01.VowelsFilter.VowelFilter;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class VowelFilterTest {

    @Test
    void testFilterVowels() {
        //Given
        BufferedReader br = new BufferedReader(new StringReader(
                "Aprócska\n" +
                        "Kalapocska\n" +
                        "Benne\n" +
                        "Csacska\n" +
                        "Macska\n" +
                        "Mocska"
        ));

        VowelFilter vf = new VowelFilter();
        //When
        String result = vf.filterVowels(br);
        //Then
        assertEquals(
                "prcsk\n" +
                        "Klpcsk\n" +
                        "Bnn\n" +
                        "Cscsk\n" +
                        "Mcsk\n" +
                        "Mcsk", result);
    }

    @Test
    void testFilterVowelWithNull() {
        VowelFilter vf = new VowelFilter();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> vf.filterVowels(null));
        assertEquals("Reader is null", ex.getMessage());
    }
}