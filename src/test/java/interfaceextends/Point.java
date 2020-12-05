package interfaceextends;

import org.junit.jupiter.api.Test;

public class Point {
    private final long x, y, z;

    public Point(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long getZ() {
        return z;
    }
}
