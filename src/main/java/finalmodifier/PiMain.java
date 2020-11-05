package finalmodifier;

import java.util.concurrent.Callable;

public class PiMain {
    public static void main(String[] args) {
        System.out.println(CircleCalculator.PI);

        System.out.println("-----Circle-----");
//        CircleCalculator circleCalculator = new CircleCalculator();
//        System.out.println(circleCalculator.calculatePerimeter(10));
//        System.out.println(circleCalculator.calculateArea(10));
        System.out.println(CircleCalculator.calculatePerimeter(10));
        System.out.println(CircleCalculator.calculateArea(10));

        System.out.println("-----Cylinder-----");
        CylinderCalculator cylinderCalculator = new CylinderCalculator();
        System.out.println(cylinderCalculator.calculateSurfaceArea(10, 5));
        System.out.println(cylinderCalculator.calculateVolume(10, 5));

        System.out.println("-----Tax-----");
        TaxCalculator taxCalculator = new TaxCalculator();
        System.out.println(taxCalculator.tax(100));
        System.out.println(taxCalculator.priceWithTax(100));

        System.out.println("-----CylinderBasedOnCircle-----");
        CylinderCalculatorBasedOnCircle Ccboc = new CylinderCalculatorBasedOnCircle();
        System.out.println(Ccboc.calculateVolume(10, 5));
        System.out.println(Ccboc.calculateSurfaceArea(10, 5));

    }
}
