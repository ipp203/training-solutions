package week10.d05;

public class CalculatorData {
    private int minSum;
    private int maxSum;

    public CalculatorData(int minSum, int maxSum) {
        this.minSum = minSum;
        this.maxSum = maxSum;
    }

    public int getMinSum() {
        return minSum;
    }

    public int getMaxSum() {
        return maxSum;
    }

    @Override
    public String toString() {
        return "minSum=" + minSum + ", maxSum=" + maxSum;
    }
}
