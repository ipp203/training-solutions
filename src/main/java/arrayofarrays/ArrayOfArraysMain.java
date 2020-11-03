package arrayofarrays;

import java.time.Month;
import java.time.MonthDay;

public class ArrayOfArraysMain {

    int[][] multiplicationTable(int size){
        int[][] aA = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                aA[i][j]=(i+1)*(j+1);
            }
        }
        return aA;
    }

    void printArrayOfArrays(int[][] a){
        for (int[] ai : a) {
            for (int aj: ai) {
                String s3 = ""+aj;
                for (int i = s3.length(); i < 3 ; i++) {
                    s3 = " " + s3;
                }
                System.out.print(s3);
            }
            System.out.println();
        }
    }

    int[][] triangularMatrix(int size){
        int[][] triM = new int[size][];

        for (int i = 0; i < size; i++) {
            triM[i] = new int[i+1];
            for (int j = 0; j <= i; j++) {
                triM[i][j]=i;
            }
        }
        return triM;
    }

    int[][] getValues(){
        int[][] values = new int[12][];
        int[] numberOfDaysInMonth = {31,30,31,30,31,30,30,31,30,31,30,31};

        for (int i = 0; i < 12; i++) {
            values[i] = new int[numberOfDaysInMonth[i]];
        }
        return values;
    }

    public static void main(String[] args) {
        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();

        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.multiplicationTable(5));

        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.triangularMatrix(5));

        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.getValues());


    }
}
