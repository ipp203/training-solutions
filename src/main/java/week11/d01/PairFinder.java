package week11.d01;

import java.util.Arrays;

public class PairFinder {

    public int findPairs(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is null or empty");
        }

        int[] myArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(myArr);

        int result = 0;
        int last = myArr[0];
        for (int i = 1; i < myArr.length; i++) {
            if (myArr[i] == last) {
                result++;
                i++;
            }
            if (i < myArr.length) {
                last = myArr[i];
            }
        }
        return result;
    }
}
