package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int h, m, s;

        System.out.println("Add meg az órát!");
        h = scn.nextInt();
        scn.nextLine();
        System.out.println("Add meg a percet!");
        m = scn.nextInt();
        scn.nextLine();
        System.out.println("Add meg a másodpercet!");
        s = scn.nextInt();
        scn.nextLine();

        Time time1 = new Time(h,m,s);

        System.out.println("Az első időpont: " + time1.toString() + " = " + time1.getInMinutes() +  " perc");

        System.out.println("Add meg az órát!");
        h = scn.nextInt();
        scn.nextLine();
        System.out.println("Add meg a percet!");
        m = scn.nextInt();
        scn.nextLine();
        System.out.println("Add meg a másodpercet!");
        s = scn.nextInt();
        scn.nextLine();

        Time time2 = new Time(h,m,s);

        System.out.println("A második időpont: " + time2.toString() +  " = " + time1.getInSeconds() +  " másodperc");

        System.out.println("Az első korábbi, mint a második: " + time1.earlierThan(time2));

    }
}
