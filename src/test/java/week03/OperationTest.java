package week03;

import org.junit.jupiter.api.Test;
import week03.d05.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {
    @Test
    void createTest() {
        Operation operation = new Operation("1+1");
        assertEquals(2, operation.getResult());
    }
}
