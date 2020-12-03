package abstractclass.gamecharacter;

public class Point {
    private long x, y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long distance(Point point) {
        return (long) Math.sqrt((this.x - point.x) * (this.x - point.x) +
                (this.y - point.y) * (this.y - point.y));
    }

}
