package week07.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {


    @Test
    void testFibonacci() {
        Fibonacci fibi = new Fibonacci();
        assertEquals(2, fibi.fib(3));
        assertEquals(34, fibi.fib(9));
        System.out.println(fibi.fib(100));
    }

}