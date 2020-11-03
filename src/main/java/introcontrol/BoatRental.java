package introcontrol;

import java.util.Scanner;

public class BoatRental {

    public void printBoats(int numOfBoater) {
        int boat1 = 2, boat2 = 3, boat3 = 5;

        if (numOfBoater > 0) {
            if (numOfBoater <= boat1) {
                System.out.println(boat1 + " fős csónak foglalt, még " + (boat2 + boat3) + " hely van.");
            } else {
                if (numOfBoater <= boat2) {
                    System.out.println(boat2 + " fős csónak foglalt, még " + (boat1 + boat3) + " hely van.");
                } else {
                    if (numOfBoater <= boat3) {
                        System.out.println(boat3 + " fős csónak foglalt, még " + (boat1 + boat2) + " hely van.");
                    } else {
                        if (numOfBoater <= boat1 + boat3) {
                            System.out.println(boat1 + " és " + boat3 + " fős csónak foglalt, még " + boat2 + " hely van.");
                        } else {
                            if (numOfBoater <= boat2 + boat3) {
                                System.out.println(boat2 + " és " + boat3 + " fős csónak foglalt, még " + boat1 + " hely van.");
                            } else {
                                if (numOfBoater <= boat1 + boat2 + boat3) {
                                    System.out.println("Összes csónak foglalt, még " + 0 + " hely van.");
                                } else {
                                    System.out.println("Összes csónak foglalt, még " + (numOfBoater - 10) + "-en várnak.");
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg a csónakázók számát!");
        int numOfBoater = scanner.nextInt();

        BoatRental boatRental = new BoatRental();
        boatRental.printBoats(numOfBoater);

        //Teszt
        for (int i = 0; i < 12; i++) {
            System.out.println(i);
            boatRental.printBoats(i);
        }

    }
}
