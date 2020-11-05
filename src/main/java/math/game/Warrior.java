package math.game;

import java.util.Random;

public class Warrior {
    private String name;
    private int stamina;
    private double skill;
    private Point position;
    private Random rnd = new Random();

    public Warrior(String name, Point position) {
        this.name = name;
        this.position = position;
        skill = rnd.nextDouble();
        stamina = rnd.nextInt(81) + 20;
    }

    public Point getPosition() {
        return position;
    }

    public void move(Warrior otherWarrior) {
        int ownX = position.getX();
        int ownY = position.getY();
        int otherX = otherWarrior.position.getX();
        int otherY = otherWarrior.position.getY();

        /*if (Math.abs(ownX - otherX) > Math.abs(ownY - otherY)) {
            ownX = ownX < otherX ? ownX + 1 : ownX - 1;
        } else {
            if (Math.abs(ownX - otherX) < Math.abs(ownY - otherY)) {
                ownY = ownY < otherY ? ownY + 1 : ownY - 1;
            } else {
                if (ownX != otherX) {
                    ownX = ownX < otherX ? ownX + 1 : ownX - 1;
                }
                if (ownY != otherY) {
                    ownY = ownY < otherY ? ownY + 1 : ownY - 1;
                }
            }
        }*/

        ownX-=Math.signum(ownX-otherX);
        ownY-=Math.signum(ownY-otherY);

        position = new Point(ownX, ownY);
    }

    public double distance(Warrior otherWarrior) {
        return position.distance(otherWarrior.getPosition());
    }

    public void attack(Warrior otherWarrior) {
        double randomSkill = rnd.nextDouble();
        if (randomSkill > otherWarrior.skill) {
            otherWarrior.stamina -= rnd.nextInt(3) + 1;
        }
    }

    public boolean isAlive() {
        return stamina > 0;
    }

    public String toString() {
        return name + ": (" + position.getX() + "," + position.getY() + ") " + stamina;
    }
}
