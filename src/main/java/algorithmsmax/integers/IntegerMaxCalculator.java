package algorithmsmax.integers;

import java.util.List;

public class IntegerMaxCalculator {


    public Integer max(List<Integer> integers) {
        Integer maxInteger = Integer.MIN_VALUE;
        for (Integer i : integers) {
            if (i > maxInteger) {
                maxInteger = i;
            }
        }
        return maxInteger;
    }
}
