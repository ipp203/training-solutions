package math.game;

public class Game {
    public static void main(String[] args) {
        Warrior w1 = new Warrior("Peter", new Point(9, 15));
        Warrior w2 = new Warrior("Pal", new Point(25, 35));

        System.out.println("0. lépés");
        System.out.println(w1.toString());
        System.out.println(w2.toString());

        for (int i = 0; w1.distance(w2) > 0; i++) {
            w1.move(w2);
            w2.move(w1);
            System.out.println((i + 1) + ". lépés");
            System.out.println(w1.toString());
            System.out.println(w2.toString());
        }

        System.out.println("-----------Támadás!!--------------");
        for (int i = 0; w1.isAlive() && w2.isAlive(); i++) {
            w1.attack(w2);
            w2.attack(w1);
            System.out.println(i + ". csata");
            System.out.println(w1.toString());
            System.out.println(w2.toString());
        }
        if (w1.isAlive()) {
            System.out.println("Győzött: " + w1.toString());
        } else {
            System.out.println("Győzött: " + w2.toString());
        }

    }
}
