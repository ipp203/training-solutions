package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<Ship> ships = new ArrayList<>();
    private int waitingPersons;
    private int waitingCargo;

    public int getWaitingPersons() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void loadShip(int passengers, int weight) {
        waitingPersons = passengers;
        waitingCargo = weight;
        for (Ship ship : ships) {
            if (ship instanceof Liner) {
                waitingPersons = ((Liner) ship).loadPassenger(waitingPersons);
            }
            if (ship instanceof CargoShip) {
                waitingCargo = ((CargoShip) ship).loadCargo(waitingCargo);
            }
            if (ship instanceof FerryBoat) {
                waitingPersons = ((FerryBoat) ship).loadPassenger(waitingPersons);
                waitingCargo = ((FerryBoat) ship).loadCargo(waitingCargo);
            }
        }
    }
}
