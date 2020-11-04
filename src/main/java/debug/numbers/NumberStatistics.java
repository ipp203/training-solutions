package debug.numbers;

import java.util.Arrays;
import java.util.List;

public class NumberStatistics {
    private List<Integer> numbers;

    public NumberStatistics(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sumPositives() {
        int sum = 0;
        for (int n : numbers) {
            if (n > 0) {
                sum += n;
            }
        }
        return sum;
    }

    private int absolute(int a) {
        return a > 0 ? a : -a;
    }

    public int minDifferenceBetweenNeighbours() {
        if (numbers.size() < 2) {
            return -1;
        }
        int minDifference = absolute(numbers.get(0) - numbers.get(1));
        for (int i = 1; i < numbers.size() - 1; i++) {
            int actDifference = absolute(numbers.get(i) - numbers.get(i + 1));
            if (actDifference < minDifference) {
                minDifference = actDifference;
            }
        }
        return minDifference;
    }

    public static void main(String[] args) {
        new NumberStatistics(Arrays.asList(4, 8, -1, -2, 4, 5, 3)).sumPositives();// --> 24
        new NumberStatistics(Arrays.asList(4, 8, -1, -2, 4, 5, 3)).minDifferenceBetweenNeighbours();// --> 1
        new NumberStatistics(Arrays.asList(-3, -4)).sumPositives();// --> 0
        new NumberStatistics(Arrays.asList(1)).minDifferenceBetweenNeighbours();//???? --> IllegalStateException
    }
}
