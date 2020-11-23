package immutable;

public class Satellite {
    private CelestialCoordinates celestialCoordinates;
    private final String registerIdent;

    public Satellite(CelestialCoordinates celestialCoordinates, String registerIdent) {
        if (registerIdent == null || registerIdent.isBlank()) {
            throw new IllegalArgumentException("Register ident must not be empty!");
        }
        this.celestialCoordinates = celestialCoordinates;
        this.registerIdent = registerIdent;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    public void modifyDestination(CelestialCoordinates diff) {
        if (diff == null) {
            throw new IllegalArgumentException("Coordinates can not be modified.");
        }
        int x, y, z;
        x = diff.getX() + celestialCoordinates.getX();
        y = diff.getY() + celestialCoordinates.getY();
        z = diff.getZ() + celestialCoordinates.getZ();

        celestialCoordinates = new CelestialCoordinates(x, y, z);
    }

    public String toString() {
        return registerIdent + ": " + celestialCoordinates.toString();
    }
}
