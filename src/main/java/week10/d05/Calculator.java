package week10.d05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
//Listaval
    public CalculatorData findMinMaxSum1(int[] arr) {
        List<Integer> arrList = new ArrayList<>();
        for (int a : arr) {
            arrList.add(a);
        }
        arrList.sort(null);

        int sumMin = 0;
        int sumMax = 0;
        int numberOfData = Math.min(4, arr.length);
        for (int i = 0; i < numberOfData; i++) {
            sumMin += arrList.get(i);
            sumMax += arrList.get(arrList.size() - i - 1);
        }
        return new CalculatorData(sumMin, sumMax);
    }

//gyalog
    public CalculatorData findMinMaxSum2(int[] arr) {

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
        return new CalculatorData(sumMin, sumMax);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérek egész számokat vesszővel elválasztva!");
        String line = scanner.nextLine();
        String[] data = line.split(",");
        int[] numbers = new int[data.length];
        int i = 0;
        for (String s : data) {
            numbers[i] = Integer.parseInt(s);
            i++;
        }
        Calculator c = new Calculator();
        System.out.println(c.findMinMaxSum1(numbers));
        System.out.println(c.findMinMaxSum2(numbers));
    }
}
