package finalmodifier;

public class CircleCalculator {
    public static final double PI = 3.14;

    public static double calculatePerimeter(double r) {
        return 2 * r * PI;
    }

    public static double calculateArea(double r){
        return r*r*PI;
    }
}
