package isahasa.fleet;

public class CargoShip implements Ship, CanCarryGoods {
    CanCarryGoods canCarryGoods;

    public CargoShip(int maxWeight) {
        this.canCarryGoods = new CanCarryGoodsBehaviour(maxWeight);
    }

    @Override
    public int loadCargo(int cargoWeight) {
        return canCarryGoods.loadCargo(cargoWeight);
    }

    @Override
    public int getCargoWeight() {
        return canCarryGoods.getCargoWeight();
    }
}
