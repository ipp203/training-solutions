package methodpass;

public class Trooper {
    private Position position = new Position(0.0, 0.0);
    private String name;

    public Trooper(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void changePosition(Position target) {
        if (target == null) {
            throw new IllegalArgumentException("Target can not be null");
        }
        position = target;
    }

    public double distanceFrom(Position target) {
        if (target == null) {
            throw new IllegalArgumentException("Target can not be null");
        }
        return position.distanceFrom(target);
    }
}
