package finalmodifier;

import java.util.Scanner;

public class Gentleman {
    private static final String MESSAGE_PREFIX = "Hello ";

    public String sayHello(String name) {
        return MESSAGE_PREFIX + name;
    }

    public static void main(String[] args) {
        Gentleman gentleman = new Gentleman();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Írd be a neved!");
        System.out.println(gentleman.sayHello(scanner.nextLine()));
    }
}
