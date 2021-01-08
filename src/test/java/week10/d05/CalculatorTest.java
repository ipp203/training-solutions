package week10.d05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    PrintStream oldStream;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream myStream = new PrintStream(baos);

    @BeforeEach
    void init(){
        oldStream =System.out;
        System.setOut(myStream);
    }

    @AfterEach
    void reset(){
        System.setOut(oldStream);
    }

    @Test
    void testFindMinMaxSum(){
        Calculator c = new Calculator();
        c.findMinMaxSum1(new int[]{1,3,5,7,9});
        assertEquals("MinSum: 16 MaxSum: 24",baos.toString().strip());

    }
}