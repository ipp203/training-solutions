package introcontrol;

import java.util.Scanner;

public class Qualifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         System.out.println("Write a number!");

         if (scanner.nextInt()>100) {
             System.out.println("Nagyobb, mint száz");
         }else{
             System.out.println("Száz, vagy kisebb");
         }

    }
}
