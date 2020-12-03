package abstractclass.gamecharacter;

import java.util.Random;

public class AxeWarrior extends Character {
    public AxeWarrior(Point position, Random random) {
        setPosition(position);
        setRandom(random);
    }

    private int getActualSecondaryDamage() {
        return getRandom().nextInt(2 * getActualPrimaryDamage()) + 1;
    }

    @Override
    public void secondaryAttack(Character enemy) {
        if (getPosition().distance(enemy.getPosition()) < 2) {
            hit(enemy, getActualSecondaryDamage());
        }
    }
}
