package interfaceextends;

import java.util.ArrayList;
import java.util.List;

public class C3PO implements MoveableRobot {
    private Point position;
    private int angle;
    private List<Point> points = new ArrayList<>();

    public C3PO(Point point) {
        this.position = point;
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    @Override
    public void moveTo(Point position) {
        this.position = position;
        savePosition(position);
    }

    @Override
    public void fastMoveTo(Point position) {
        moveTo(position);
    }

    @Override
    public void rotate(int angle) {
        this.angle += angle;
    }

    @Override
    public List<Point> getPath() {
        return List.copyOf(points);
    }

    private void savePosition(Point position) {
        points.add(position);
    }
}
