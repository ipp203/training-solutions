package inheritanceconstructor;

public class Jeep extends Car {
    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        if (extraFuel > extraCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    @Override
    public void modifyFuelAmount(double fuel) {
        if (super.calculateRefillAmount() > fuel) {
            super.modifyFuelAmount(fuel);
        } else {
            super.modifyFuelAmount(super.calculateRefillAmount());
            fuel -= super.calculateRefillAmount();
            extraFuel += fuel;
            extraFuel = Math.min(extraFuel, extraCapacity);
        }
    }

    @Override
    public void drive(int km) {// csökkenti az üzemanyag mennyiségét, nem fogyhat ki!
        if (!isFuelEnough(km)) {
            throw new RuntimeException("Not enough fuel available!");
        }
        double needFuel = super.getFuelRate() * km / 100.0;
        if (needFuel < extraFuel) {
            extraFuel -= needFuel;
        } else {
            needFuel -= extraFuel;
            super.modifyFuelAmount(-needFuel);
            extraFuel = 0;
        }
    }

    @Override
    public double calculateRefillAmount() { //kiszámolja, mennyit lehet tankolni
        return extraCapacity - extraFuel + super.calculateRefillAmount();
    }

    private boolean isFuelEnough(double km) {
        return extraFuel + super.getFuel() > super.getFuelRate() * km / 100;
    }
}
