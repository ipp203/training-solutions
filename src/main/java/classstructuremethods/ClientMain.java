package classstructuremethods;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        Scanner scn = new Scanner(System.in);

        System.out.println("What's your name?");
        client.setName(scn.nextLine());
        System.out.println("What's your address?");
        client.setAddress(scn.nextLine());
        System.out.println("Year of Birth?");
        client.setYear(scn.nextInt());
        scn.nextLine();

        System.out.println("Name: " + client.getName() +
                           " Address: " + client.getAddress() +
                           " Year of birth: " + client.getYear() );

        System.out.println("Where did you migrate? New Address:");
        client.migrate(scn.nextLine());
        System.out.println("Your new address: " + client.getAddress());

    }
}
