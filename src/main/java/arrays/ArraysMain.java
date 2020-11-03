package arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMain {

    String numberOfDaysAsString() {
        int[] numberOfDays = {31, 30, 31, 30, 31, 30, 30, 31, 30, 31, 30, 31};
        return Arrays.toString(numberOfDays);
    }

    /*List<String> daysOfWeek(){
        ?????????
    }*/

    String multiplicationTableAsString(int size) {
        int[][] multiplicationTable = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);
            }
        }
        return Arrays.deepToString(multiplicationTable);
    }

    boolean sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day, anotherDay);
    }

    boolean wonLottery(int[] ticket, int[] lottery) {
        int[] ownTicket = Arrays.copyOf(ticket, ticket.length);
        int[] ownLottery = Arrays.copyOf(lottery, lottery.length);
        Arrays.sort(ownTicket);
        Arrays.sort(ownLottery);
        return Arrays.equals(ownTicket, ownLottery);
    }

    int min(int a, int b) {
        return a < b ? a : b;
    }

    boolean sameTempValuesDaylight(double[] day, double[] anotherDay) {

        return Arrays.equals(Arrays.copyOfRange(day       , 0, min(day.length, anotherDay.length)),
                             Arrays.copyOfRange(anotherDay, 0, min(day.length, anotherDay.length)));
    }

    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();

        System.out.println(arraysMain.numberOfDaysAsString());

        System.out.println(arraysMain.multiplicationTableAsString(5));

        System.out.println("-------sameTempValues--------");
        double[] day1 = {21.0, 21.2, 21.5, 22.0}, day2 = {21.0, 21.2, 21.5, 22.1};
        System.out.println(arraysMain.sameTempValues(day1, day2));
        System.out.println(arraysMain.sameTempValues(day1, day1));

        System.out.println("-------wonLottery--------");
        int[] ticket = {5, 25, 63, 9, 2};
        int[] lottery = {1, 8, 65, 42, 31};
        System.out.println(arraysMain.wonLottery(ticket, ticket));
        System.out.println(arraysMain.wonLottery(ticket, lottery));
        System.out.println(Arrays.toString(ticket));
        System.out.println(Arrays.toString(lottery));

        System.out.println("-----------sameTempValuesDaylight----------");
        double[] day        = {1.0,2.0,3.0,4.0,5.0};
        double[] anotherDay = {1.0,2.0,3.0,4.0,5.0,6.0};
        System.out.println(arraysMain.sameTempValuesDaylight(day,anotherDay));
    }
}
