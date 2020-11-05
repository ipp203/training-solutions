package finalmodifier;

public class CylinderCalculatorBasedOnCircle {
    public double calculateVolume(double r, double h) {
        return CircleCalculator.calculateArea(r) * h;
    }

    public double calculateSurfaceArea(double r, double h) {
        return 2 * CircleCalculator.calculateArea(r) + CircleCalculator.calculatePerimeter(r) * h;
    }

}
