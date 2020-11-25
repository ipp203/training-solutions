package methodpass;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {
    private List<Trooper> troopers = new ArrayList<>();

    public List<Trooper> getTroopers() {
        return troopers;
    }

    public void addTrooper(Trooper trooper) {
        if (trooper == null) {
            throw new IllegalArgumentException("Trooper must not be empty!");
        }
        troopers.add(trooper);
    }

    public void moveTrooperByName(String name, Position target) {
        if (isEmpty(name) || isEmpty(target)) {
            throw new IllegalArgumentException("Argument must not be empty!");
        }
        moveTrooper(findTrooperByName(name), target);
    }

    public void moveClosestTrooper(Position target) {
        if (isEmpty(target)) {
            throw new IllegalArgumentException("Target must not be empty!");
        }
        moveTrooper(findClosestTrooper(target), target);
    }

    private Trooper findTrooperByName(String name) {
        for (Trooper trooper : troopers) {
            if (trooper.getName().equals(name)) {
                return trooper;
            }
        }
        throw new IllegalStateException("No any trooper in the List");
    }

    private Trooper findClosestTrooper(Position target) {
        double minDistance = Double.POSITIVE_INFINITY;
        Trooper closestTrooper = null;
        for (Trooper trooper : troopers) {
            if (trooper.distanceFrom(target) < minDistance) {
                closestTrooper = trooper;
                minDistance = trooper.distanceFrom(target);
            }
        }
        if (isEmpty(closestTrooper)) {
            throw new IllegalStateException("No any trooper in the List");
        }
        return closestTrooper;
    }

    private void moveTrooper(Trooper trooper, Position target) {
        trooper.changePosition(target);
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    private boolean isEmpty(Position position) {
        return position == null;
    }

    private boolean isEmpty(Trooper trooper) {
        return trooper == null;
    }
}
