package week08.d01;

import java.util.ArrayList;
import java.util.List;

public class Sultan {
    private final int numberOfDoors;
    private boolean[] doors;

    public Sultan(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
        doors = new boolean[numberOfDoors];
    }

    public List<Integer> openDoors(int numberOfDays) {
        for (int day = 1; day <= numberOfDays; day++) {
            openDoorsOneDay(day);
        }

        return getOpenedDoors();
    }

    private void openDoorsOneDay(int day) {
        for (int i = 0; i < numberOfDoors; i++) {
            if ((i + 1) % day == 0) {
                doors[i] = !doors[i];
            }
        }
    }

    private List<Integer> getOpenedDoors() {
        List<Integer> openedDoors = new ArrayList<>();

        for (int i = 0; i < numberOfDoors; i++) {
            if (doors[i]) {
                openedDoors.add(i + 1);
            }
        }
        return List.copyOf(openedDoors);
    }
}
