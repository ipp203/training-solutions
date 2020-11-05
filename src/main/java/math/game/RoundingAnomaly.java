package math.game;

import java.util.Random;

public class RoundingAnomaly {
    private Random rnd = new Random();

    public double[] randomNumbers(int size, double max, int scale) {
        double[] numbers = new double[size];
        double rounder = Math.pow(10, scale);

        for (int i = 0; i < size; i++) {
            numbers[i] = Math.round(rounder * (rnd.nextDouble() * max)) / rounder;
        }
        return numbers;
    }

    public double roundAfterSum(double[] numbers) {
        double sum = 0;
        for (double d : numbers) {
            sum += d;
        }
        return Math.round(sum);
    }

    public double sumAfterRound(double[] numbers) {
        double sum = 0;
        for (double d : numbers) {
            sum += Math.round(d);
        }
        return sum;
    }

    public double difference(int size, double max, int scale) {
        double[] numbers = randomNumbers(size, max, scale);
        return roundAfterSum(numbers) - sumAfterRound(numbers);
    }

    public static void main(String[] args) {
        RoundingAnomaly roundingAnomaly = new RoundingAnomaly();
        double diff, average = 0;
        for (int i = 0; i < 100; i++) {
            diff = roundingAnomaly.difference(1000, 1_000_000, 5);
            System.out.println(diff);
            average += diff;
        }
        System.out.println(average / 100);
    }


}
