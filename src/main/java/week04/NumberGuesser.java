package week04;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
    private int number;

    public NumberGuesser() {
        number = new Random().nextInt(100) + 1;
    }

    public boolean isGreater(int number) {
        return number > this.number;
    }

    public boolean isLess(int number) {
        return number < this.number;
    }

    public boolean isEqual(int number) {
        return number == this.number;
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Számkitalálósdi.");
        NumberGuesser ng = new NumberGuesser();
        int number = 0;
        int i = 0;
        do {
            i++;
            System.out.println("Add meg a/az " + i + ". számot!");
            number = scn.nextInt();
            scn.nextLine();
            if (ng.isGreater(number)) {
                System.out.println("Nagyobb számot adtál meg.");
            }
            if (ng.isLess(number)) {
                System.out.println("Kisebb számot adtál meg.");
            }

        }
        while (!ng.isEqual(number));
        System.out.println("Talált a/az " + i + ". lépésben");


    }

}
