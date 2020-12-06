package isahasa.fleet;

public class FerryBoat implements Ship, CanCarryGoods, CanCarryPassengers {
    CanCarryGoods canCarryGoods;
    CanCarryPassengers canCarryPassengers;

    public FerryBoat(int maxWeight, int maxPassengers) {
        this.canCarryGoods = new CanCarryGoodsBehaviour(maxWeight);
        this.canCarryPassengers = new CanCarryPassengersBehaviour(maxPassengers);
    }

    @Override
    public int loadCargo(int cargoWeight) {
        return canCarryGoods.loadCargo(cargoWeight);
    }

    @Override
    public int getCargoWeight() {
        return canCarryGoods.getCargoWeight();
    }

    @Override
    public int loadPassenger(int passengers) {
        return canCarryPassengers.loadPassenger(passengers);
    }

    @Override
    public int getPassengers() {
        return canCarryPassengers.getPassengers();
    }
}
