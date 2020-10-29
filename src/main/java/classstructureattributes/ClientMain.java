package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        Scanner scn = new Scanner(System.in);

        System.out.println("What's your name?");
        client.name = scn.nextLine();
        System.out.println("Year of birth?");
        client.year = scn.nextInt();
        scn.nextLine();
        System.out.println("Address?");
        client.address = scn.nextLine();
        System.out.println("Your data:");
        System.out.println("Name: " + client.name + " Year of birth: " + client.year +
                            " Address: " + client.address);
    }
}
