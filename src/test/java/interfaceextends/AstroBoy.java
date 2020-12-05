package interfaceextends;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot {
    private Point position;
    private int angle;
    private List<Point> path;
    public static final long ALTITUDE = 5;

    public AstroBoy(Point position) {
        this.position = position;
        path = new ArrayList<>();
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    public long getAltitude() {
        return position.getZ();
    }

    public void walkTo(Point position) {
    }

    public void flyTo(Point position) {
    }


    @Override
    public void liftTo(long altitude) {
        position = new Point(position.getX(), position.getY(), altitude);
        savePosition(position);
    }

    @Override
    public void moveTo(Point position) {// delegálja a funkciót
        this.position = position;
        savePosition(position);
    }

    @Override
    public void fastMoveTo(Point position) {//komplex mozgás, felemelkedik, elrepül a célpont fölé, és leereszkedik
        liftTo(ALTITUDE);
        moveTo(new Point(position.getX(), position.getY(), ALTITUDE));
        liftTo(position.getZ());
    }

    @Override
    public void rotate(int angle) {
        this.angle += angle;
    }

    @Override
    public List<Point> getPath() {
        return List.copyOf(path);
    }

    private void savePosition(Point position) {
        path.add(position);
    }
}
