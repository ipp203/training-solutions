package week16.d01.CanoeRentals;

public enum CanoeType {
    RED(1), GREEN(1.2), BLUE(1.5);

    private double value;

    CanoeType(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
