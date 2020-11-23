package methodstructure;

public class Pendrive {
    private final String name;
    private final int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return "";
    }

    public void risePrice(int percent) {
        price += price * ((double) percent / 100.0);
    }

    public int comparePricePerCapacity(Pendrive pendrive) {
        double myValue = (double) price / capacity;
        double value = (double) pendrive.price / pendrive.capacity;
        if (myValue < value) {
            return -1;
        } else if (myValue > value) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean cheaperThan(Pendrive pendrive) {
        return price < pendrive.price;
    }

}
