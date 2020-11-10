package numbers;

public class Circle {
    private int diameter;
    private static final double PI = 3.14;

    public Circle(int diameter) {
        this.diameter = diameter;
    }

    public double perimeter() {
        return diameter * PI;
    }

    public double area() {
        return diameter * diameter * PI / 4;
    }
}

