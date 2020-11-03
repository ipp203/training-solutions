package array;

import static java.lang.Math.pow;

public class ArrayMain {
    public static void main(String[] args) {

        String[] dayOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println(dayOfWeek[1]);
        System.out.println(dayOfWeek.length);

        int[] powerOf2 = new int[5];
        for (int i = 0; i < 5; i++) {
            powerOf2[i] = (int) pow(2, i);
        }
        for (int item:powerOf2) {
            System.out.println(item);
        }

        boolean[] arrayOfBoolean = new boolean[6];
        for (int i = 0; i < arrayOfBoolean.length; i++) {
            arrayOfBoolean[i] = (i % 2 == 1);
        }
        for (boolean item:arrayOfBoolean) {
            System.out.println(item);
        }

        //Test ArrayHandler
        ArrayHandler arrayHandler = new ArrayHandler();
        System.out.println();
        System.out.println(arrayHandler.contains(powerOf2,2));
        System.out.println(arrayHandler.contains(powerOf2,3));

        System.out.println();
        System.out.println(arrayHandler.find(powerOf2,16));
        System.out.println(arrayHandler.find(powerOf2,3));

    }
}
