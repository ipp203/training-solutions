package methodchain;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private int distance;
    private int azimut;
    List<NavigationPoint> navigationList;

    public Robot() {
        navigationList = new ArrayList<>();
    }

    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }

    public List<NavigationPoint> getNavigationList() {
        return List.copyOf(navigationList);
    }

    public Robot go(int meter) {
        distance += meter;
        return this;
    }

    public Robot rotate(int angle) {
        azimut = (azimut + angle) % 360;
        return this;
    }

    public Robot registerNavigationPoint() {
        navigationList.add(new NavigationPoint(distance, azimut));
        return this;
    }

}
