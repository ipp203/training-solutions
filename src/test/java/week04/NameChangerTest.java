package week04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class NameChangerTest {
    @Test
    void createTest() {
        NameChanger nameChanger = new NameChanger("Doe Jhon");
        nameChanger.changeFirsName("Jack");
        assertEquals("Doe Jack", nameChanger.getFullname());
    }
}
