package inheritanceconstructor;

public class Car {
    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if (fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public void modifyFuelAmount(double fuel) {
        this.fuel += fuel;
        this.fuel = Math.min(this.fuel, tankCapacity);
    }

    public void drive(int km) {
        if (isFuelEnough(km)) {
            fuel -= fuelRate * km / 100.0;
        } else {
            throw new RuntimeException("Not enough fuel available!");
        }
    }

    public double calculateRefillAmount() {
        return tankCapacity - fuel;
    }

    private boolean isFuelEnough(int km) {
        return fuel - fuelRate * km / 100.0 > 0;
    }

}
