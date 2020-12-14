package week08.d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SultanTest {

    @Test
    void testSultansDoors() {
        Sultan sultan = new Sultan(100);
        List<Integer> openedDoors = sultan.openDoors(100);
        System.out.println(openedDoors);
    }
}