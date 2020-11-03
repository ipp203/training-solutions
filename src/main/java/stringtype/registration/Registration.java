package stringtype.registration;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserValidator userValidator = new UserValidator();

        System.out.println("Add meg a felhasználó neved!");
        boolean b = userValidator.isValidUserName(scanner.nextLine());
        System.out.println(b ? "Köszönöm" : "A megadott név nem elég hosszú!");

        System.out.println("Add meg a jelszavadat! (legalább 8 hosszú)");
        String pwd1 = scanner.nextLine();
        System.out.println("Add meg újra a jelszavadat!");
        String pwd2 = scanner.nextLine();
        b = userValidator.isValidPassword(pwd1,pwd2);
        System.out.println(b ? "Köszönöm" : "A megadott jelszavak nem jók!");

        System.out.println("Add meg az e-mail címed!");
        b = userValidator.isValidEmail(scanner.nextLine());
        System.out.println(b ? "Köszönöm" : "A megadott e-mail nem megfelelő!");
    }
}
