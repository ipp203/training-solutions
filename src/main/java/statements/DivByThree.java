package statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {
        System.out.println("Írj ide egy számot, megmondom, hárommal osztható-e!");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println("A megadott szám " + (i%3==0?"":"nem ") + "osztható hárommal.");
    }
}
