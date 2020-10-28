package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("This is a Calculator. First number?");
        Scanner scn = new Scanner(System.in);
        int num1 = scn.nextInt();
        System.out.println("Second number?");
        int num2 = scn.nextInt();
        System.out.println(num1 + " + " + num2);
        System.out.println(num1+num2);
    }
}
