package methoverloading;

public class Pub {
    private String name;
    private Time openFrom;

    public Pub(String name, int hours, int minutes) {
        this.name = name;
        this.openFrom = new Time(hours, minutes, 0);
    }

    public String getName() {
        return name;
    }

    public Time getOpenFrom() {
        return openFrom;
    }

    @Override
    public String toString() {
        return name + ";" + openFrom.getHours() + ":" + openFrom.getMinutes();
    }
}
