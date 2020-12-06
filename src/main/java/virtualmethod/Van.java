package virtualmethod;

public class Van extends Car {
    private int cargoWeight;

    public Van(int numberOfPassenger, int vehicleWeight, int cargoWeight) {
        super(vehicleWeight, numberOfPassenger);
        this.cargoWeight = cargoWeight;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + cargoWeight;
    }

    @Override
    public String toString() {//Van{cargoWeight=1222, numberOfPassenger=4, vehicleWeight=1200}
        return "Van{" +
                "cargoWeight=" + cargoWeight +
                ", numberOfPassenger=" + super.getNumberOfPassenger() +
                ", vehicleWeight=" + super.getVehicleWeight() +
                '}';
    }
}
