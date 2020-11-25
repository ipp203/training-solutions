package methodpass;

public class Position {
    private double posX, posY;

    public Position(double x, double y) {
        this.posX = x;
        this.posY = y;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double distanceFrom(Position position) {
        return Math.sqrt((position.posX - posX) * (position.posX - posX) +
                (position.posY - posY) * (position.posY - posY));
    }
}
