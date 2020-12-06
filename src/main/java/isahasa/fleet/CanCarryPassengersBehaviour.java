package isahasa.fleet;

public class CanCarryPassengersBehaviour implements CanCarryPassengers {
    private int passengers;
    private int maxPassengers;

    public CanCarryPassengersBehaviour(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public int loadPassenger(int passengers) {
        this.passengers = Math.min(maxPassengers, passengers);
        return Math.max(0, passengers - maxPassengers);
    }

    @Override
    public int getPassengers() {
        return passengers;
    }
}
