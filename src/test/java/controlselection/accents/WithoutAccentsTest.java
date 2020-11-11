package controlselection.accents;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WithoutAccentsTest {
    @Test
    void testCreate(){
        //Given
        WithoutAccents withoutAccents = new WithoutAccents();
        //Then
        assertEquals('a',withoutAccents.charWithoutAccents('á'));
        assertEquals('A',withoutAccents.charWithoutAccents('Á'));
        assertEquals('E',withoutAccents.charWithoutAccents('É'));
        assertEquals('S',withoutAccents.charWithoutAccents('S'));
    }
}
