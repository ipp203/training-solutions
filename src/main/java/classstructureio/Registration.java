package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("What's your name?");
        String name = scn.nextLine();
        System.out.println("What is your e-mail address?");
        String email = scn.nextLine();

        System.out.println("Your registrations data:");
        System.out.println("Name: "+name);
        System.out.println("E-mail: "+email);
    }
}
