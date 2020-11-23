package immutable;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {
    private final List<Satellite> satellites = new ArrayList<>();

    public void registerSatellite(Satellite satellite) {
        if (satellite == null) {
            throw new NullPointerException("Parameter must not be null!");
        }
        satellites.add(satellite);
    }

    public Satellite findSatelliteByRegisterIdent(String registerIdent) {
        for (Satellite sa : satellites) {
            if (sa.getRegisterIdent().equals(registerIdent)) {
                return sa;
            }
        }
        throw new IllegalArgumentException("Satellite with the given registration cannot be found!" + registerIdent);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < satellites.size(); i++) {
            result.append(satellites.get(i).toString());
            if (i < satellites.size() - 1) {
                result.append(", ");
            }
        }
        return "[" + result + "]";
    }
}
