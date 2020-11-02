package statements;

import java.util.Scanner;

public class InvestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Befektetés összege?");
        int fund = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Kamatláb?");
        int rate = scanner.nextInt();
        scanner.nextLine();

        Investment investment = new Investment(fund,rate);

        System.out.println("Hozam 100 nap után: " + investment.getYield(100));
        System.out.println("Kivett összeg 150 nap után: " + investment.close(150));
        System.out.println("Kivett összeg 160 nap után: " + investment.close(160));


    }
}
