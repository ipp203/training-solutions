package virtualmethod;

public class Car extends Vehicle {
    private int numberOfPassenger;

    public Car(int vehicleWeight, int numberOfPassenger) {
        super(vehicleWeight);
        this.numberOfPassenger = numberOfPassenger;
    }

    public int getNumberOfPassenger() {
        return numberOfPassenger;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + numberOfPassenger * PERSON_AVERAGE_WEIGHT;
    }

    @Override
    public String toString() { //Car{numberOfPassenger=4, vehicleWeight=1700}
        return "Car{" +
                "numberOfPassenger=" + numberOfPassenger +
                ", vehicleWeight=" + super.getVehicleWeight() +
                '}';
    }
}
