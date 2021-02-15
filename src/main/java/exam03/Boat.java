package exam03;

public class Boat {

    private final String name;
    private final int maxPassengers;

    public Boat(String name, int maxPassengers) {
        if (name == null || name.isBlank() || maxPassengers <= 0) {
            throw new IllegalArgumentException("Invalid arguments!");
        }
        this.name = name;
        this.maxPassengers = maxPassengers;
    }

    public String getName() {
        return name;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }
}
