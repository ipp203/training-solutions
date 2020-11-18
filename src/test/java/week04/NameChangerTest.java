package week04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class NameChangerTest {
    @Test
    public void crateNameChangerTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new NameChanger(""));
        assertEquals("Invalid name:", iae.getMessage());
    }

    @Test
    void createTest() {
        NameChanger nameChanger = new NameChanger("Doe Jhon");
        nameChanger.changeFirsName("Jack");
        assertEquals("Doe Jack", nameChanger.getFullname());
    }
}
