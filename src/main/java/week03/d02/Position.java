package week03.d02;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private String name;
    private int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return name + ", bonus=" + bonus;
    }

    public static void main(String[] args) {
        List<Position> positions = new ArrayList<>();
        final int LIMIT = 100_000;


        positions.add(new Position("Targoncas", 100_000));
        positions.add(new Position("Sofor", 160_000));
        positions.add(new Position("Pilota", 190_000));

        for (Position pos : positions) {
            if (pos.getBonus() > LIMIT) {
                System.out.println(pos);
            }
        }

    }
}
