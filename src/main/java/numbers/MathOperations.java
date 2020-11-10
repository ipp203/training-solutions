package numbers;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double DIFF = 0.0001;

        System.out.println("Oldd meg a feladatot!");
        System.out.println("(1+2)*3/4-2");
        System.out.println("Kérem az eredményt:");
        double d = scanner.nextDouble();
        double result = (1 + 2) * 3D / 4 - 2;

        if (Math.abs(d - result) < DIFF) {
            System.out.println("Az eredmény helyes, az eltérés " + Math.abs(d - result));
        } else {
            System.out.println("Nem helyes, az eltérés " + Math.abs(d - result));
        }
    }
}
