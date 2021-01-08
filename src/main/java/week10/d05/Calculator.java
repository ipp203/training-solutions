package week10.d05;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    //Listaval
    public void findMinMaxSum1(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("arr is null");
        }
        int[] myArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(myArr);

        int sumMin = 0;
        int sumMax = 0;
        int numberOfData = Math.min(4, myArr.length);
        for (int i = 0; i < numberOfData; i++) {
            sumMin += myArr[i];
            sumMax += myArr[myArr.length - i - 1];
        }
        System.out.println("MinSum: " + sumMin + " MaxSum: " + sumMax);

    }

    //gyalog
    public void findMinMaxSum2(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("arr is null");
        }
//minimum
        int sumMin = 0;
        int sumMax = 0;
        int length = Math.min(4, arr.length);
        boolean[] marksMin = new boolean[arr.length];
        for (int i = 0; i < length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < min && !marksMin[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            sumMin += min;
            marksMin[minIndex] = true;
        }
//maximum
        boolean[] marksMax = new boolean[arr.length];
        for (int i = 0; i < length; i++) {
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > max && !marksMax[j]) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            sumMax += max;
            marksMax[maxIndex] = true;
        }
        System.out.println("MinSum: " + sumMin + " MaxSum: " + sumMax);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérek egész számokat vesszővel elválasztva!");
        String line = scanner.nextLine();

        String[] data = line.split(",");
        int[] numbers = new int[data.length];
        int i = 0;
        try {
            for (String s : data) {
                numbers[i] = Integer.parseInt(s);
                i++;
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Wrong number format! " + nfe.getMessage());
            return;
        }
        Calculator c = new Calculator();
        c.findMinMaxSum1(numbers);
        c.findMinMaxSum2(numbers);
    }
}
