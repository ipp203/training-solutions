package introcontrol;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adj meg sorban 5 számot!");

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum = sum + scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Az 5 szám összege: " + sum);
    }
}
