package introcontrol;

public class IntroControl {
    public int substractTenIfGreaterThanTen(int number) {
        if (number <= 10) {
            return number;
        } else {
            return number - 10;
        }
    }

    public String describeNumber(int number){
        if (number == 0) {
            return "zero";
        } else {
            return "not zero";
        }
    }
    public String greetingToJoe(String name){
        if (name.equals("Joe")) {
            return "Hello Joe!";
        } else {
            return "";
        }
    }

    public int calculateBonus(int sale){
        if (sale > 1_000_000){
            return sale / 10;
        } else {
            return 0;
        }
    }

    public int calculateConsumtion(int prev, int next){
        if (prev<next){
            return next - prev;
        } else {
            return 10_000 - prev + next;
        }
    }

    public void printNumbers(int max){
        String numbers = "";
        for (int i = 0; i <= max; i++){
            numbers = numbers + i + ", ";
        }
        System.out.println(numbers);
    }

    public void printNumbersBetween(int min, int max){
        String numbers = "";
        for (int i = min; i <= max; i++){
            numbers = numbers + i + ", ";
        }
        System.out.println(numbers);
    }

    public void printNumbersBetweenAnyDirection(int a, int b){
        String numbers = "";
        if (a<=b) {
            for (int i = a; i <= b; i++) {
                numbers = numbers + i + ", ";
            }
        } else {
            for (int i = a; i >= b; i--) {
                numbers = numbers + i + ", ";
            }
        }
        System.out.println(numbers);
    }

    public void printOddNumbers(int max){
        String numbers = "";
        for (int i = 1; i <= max; i++) {
            if (i % 2 == 1) {
                numbers = numbers + i + ", ";
            }
        }
        System.out.println(numbers);
    }

}
