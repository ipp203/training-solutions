package week09.d02;

public class FibCalculator {

    private static Long[] valuesOfFibonacci = new Long[10000];

    public static long fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n parameter must be greater, than 0");
        }
        if (n == 0) {
            valuesOfFibonacci[n] = 0L;
        }
        if (n == 1) {
            valuesOfFibonacci[n] = 1L;
        }
        if (valuesOfFibonacci[n] == null) {
            valuesOfFibonacci[n] = fib(n - 2) + fib(n - 1);
        }
        return valuesOfFibonacci[n];
    }

    public long sumEvens(int bound) {
        long sum = 0;
        int i = 0;
        while (fib(i) < bound) {
            sum += valuesOfFibonacci[i];
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        FibCalculator fibC = new FibCalculator();
        System.out.println(fibC.sumEvens(10));
    }

}
