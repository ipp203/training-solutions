package week02;

import java.util.Scanner;

public class Controller {
    private Office office;

    public void readOffice() {
        office = new Office();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tárgyaló nyilvántartás");
        System.out.println("Hány tárgyalót szeretnél felvenni?");
        int numberOfRooms = scanner.nextInt();
        scanner.nextLine();

        String name;
        int length, width;
        for (int i = 0; i < numberOfRooms; i++) {
            System.out.println("Add meg a/az " + (i + 1) + ". tárgyaló nevét!");
            name = scanner.nextLine();
            System.out.println("Add meg a/az " + (i + 1) + ". tárgyaló hosszúságát méterben!");
            length = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Add meg a/az " + (i + 1) + ". tárgyaló szélességét méterben!");
            width = scanner.nextInt();
            scanner.nextLine();
            office.addMeetingRoom(new MeetingRoom(name, length, width));
        }
    }

    public void printMenu() {
        System.out.println("1. Tárgyalók sorrendben");
        System.out.println("2. Tárgyalók visszafele sorrendben");
        System.out.println("3. Minden második tárgyaló");
        System.out.println("4. Területek");
        System.out.println("5. Keresés pontos név alapján");
        System.out.println("6. Keresés névtöredék alapján");
        System.out.println("7. Keresés terület alapján");
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);


        for ( int userInput = 1; userInput > 0 && userInput < 8; ) {
            System.out.println("");
            System.out.println("Válassz a következő menüpontok közül!");
            printMenu();

            userInput = scanner.nextInt();
            scanner.nextLine();

            if (userInput == 1) {
                office.printNames();
            }
            if (userInput == 2) {
                office.printNamesReverse();
            }
            if (userInput == 3) {
                office.printEvenNames();
            }
            if (userInput == 4) {
                office.printAreas();
            }
            if (userInput == 5) {
                System.out.println("Add meg a keresett tárgyaló nevét!");
                office.printMeetingRoomsWithName(scanner.nextLine());
            }
            if (userInput == 6) {
                System.out.println("Adj meg a keresett tárgyaló nevéből részletet!");
                office.printMeetingRoomsContains(scanner.nextLine());
            }
            if (userInput == 7) {
                System.out.println("Add meg a területet!");
                office.printAreasLargerThan(scanner.nextInt());
                scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.readOffice();
        controller.runMenu();
    }
}
