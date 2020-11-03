package introdate;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println("Year of birth?");
        int yearOfBirth = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Month of birth? (number)");
        int monthOfBirth = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Day of birth?");
        int dayOfBirth = scanner.nextInt();
        scanner.nextLine();


        Employee employee = new Employee(yearOfBirth,monthOfBirth, dayOfBirth, name);

        System.out.println("Name: " + employee.getName());
        System.out.println("Date of birth: " + employee.getDateOfBirth());
        System.out.println("Date and time of begin employment: " + employee.getBeginEmployment());
    }
}
