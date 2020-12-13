package week07.d01;

public class Fibonacci {

    public static Long[] valuesOfFibonacci = new Long[101];

    public long fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n parameter must be greater, than 0");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (valuesOfFibonacci[n] == null) {
            valuesOfFibonacci[n] = fib(n - 2) + fib(n - 1);
        }
        return valuesOfFibonacci[n];
        //return fib(n - 2) + fib(n - 1);
    }
}
