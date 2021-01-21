package week12.d03;

import java.util.Arrays;

public class AgeSorter {
    public int[] sortAges(int[] ages) {
        int[] result = new int[ages.length];
        int[] lookup = new int[150];

        for (int age : ages) {
            lookup[age]++;
        }

        int idx = 0;
        for (int i = 0; i < lookup.length; i++) {
            for (int j = 0; j < lookup[i]; j++) {
                result[idx] = i;
                idx++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AgeSorter ageSorter = new AgeSorter();
        int[] result = ageSorter.sortAges(new int[]{1, 2, 8, 78, 4, 96, 52, 2, 78, 1, 4, 96});
        System.out.println(Arrays.toString(result));
    }
}
