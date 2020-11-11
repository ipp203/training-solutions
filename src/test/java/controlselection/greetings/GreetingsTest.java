package controlselection.greetings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingsTest {
    @Test
    void testCreate(){
        //Given
        Greetings greetings = new Greetings();
        //Then
        assertEquals("Jó éjt!",greetings.greetingsByTime(4,59));
        assertEquals("Jó reggelt!",greetings.greetingsByTime(5,0));
        assertEquals("Jó reggelt!",greetings.greetingsByTime(8,59));
        assertEquals("Jó napot!",greetings.greetingsByTime(9,0));
        assertEquals("Jó napot!",greetings.greetingsByTime(16,0));
        assertEquals("Jó napot!",greetings.greetingsByTime(18,29));
        assertEquals("Jó estét!",greetings.greetingsByTime(18,30));
        assertEquals("Jó estét!",greetings.greetingsByTime(19,59));
        assertEquals("Jó éjt!",greetings.greetingsByTime(20,00));

    }
}
