package numbers;

import java.util.Scanner;

public class CircleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem a kör átmérőjét:");
        int d = scanner.nextInt();
        scanner.nextLine();
        Circle c1 = new Circle(d);
        System.out.println("A kör kerülete: " + c1.perimeter());
        System.out.println("A kör területe: " + c1.area());

        System.out.println("Kérem a kör átmérőjét:");
        d = scanner.nextInt();
        scanner.nextLine();
        Circle c2 = new Circle(d);
        System.out.println("A kör kerülete: " + c2.perimeter());
        System.out.println("A kör területe: " + c2.area());

    }
}
