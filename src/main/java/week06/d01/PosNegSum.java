package week06.d01;

public class PosNegSum {
    private double positiveSum, negativeSum;

    public PosNegSum(double positiveSum, double negativeSum) {
        this.positiveSum = positiveSum;
        this.negativeSum = negativeSum;
    }

    public double getPositiveSum() {
        return positiveSum;
    }

    public double getNegativeSum() {
        return negativeSum;
    }

    public void addPos(double value) {
        positiveSum += value;
    }

    public void addNeg(double value) {
        negativeSum += value;
    }

}
