package week02.d04;

import java.util.Scanner;

public class InputNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Kérem az " + (i + 1) + ". nevet");
            names[i] = scanner.nextLine();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". név: " + names[i]);
        }
    }
}
