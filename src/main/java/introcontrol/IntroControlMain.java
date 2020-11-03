package introcontrol;

public class IntroControlMain {
    public static void main(String[] args) {
        IntroControl introControl = new IntroControl();

        System.out.println(introControl.substractTenIfGreaterThanTen(8));
        System.out.println(introControl.substractTenIfGreaterThanTen(15));

        System.out.println(introControl.describeNumber(0));
        System.out.println(introControl.describeNumber(10));

        System.out.println(introControl.greetingToJoe("Joe"));
        System.out.println(introControl.greetingToJoe("Jack"));

        System.out.println(introControl.calculateBonus(5_555_555));
        System.out.println(introControl.calculateBonus(555_555));

        System.out.println(introControl.calculateConsumtion(500,789));
        System.out.println(introControl.calculateConsumtion(789,500));

        introControl.printNumbers(50);

        introControl.printNumbersBetween(12,34);

        introControl.printNumbersBetweenAnyDirection(12,34);
        introControl.printNumbersBetweenAnyDirection(34,12);

        introControl.printOddNumbers(75);


    }
}
