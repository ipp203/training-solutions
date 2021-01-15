package activity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<TrackPoint> trackPoints = new ArrayList<>();

    public List<TrackPoint> getTrackPoints() {
        return List.copyOf(trackPoints);
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public Coordinate findMaximumCoordinate() {
        double maxLatitude = Double.MIN_VALUE;
        double maxLongitude = Double.MIN_VALUE;
        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLatitude() > maxLatitude) {
                maxLatitude = trackPoint.getCoordinate().getLatitude();
            }
            if (trackPoint.getCoordinate().getLongitude() > maxLongitude) {
                maxLongitude = trackPoint.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxLatitude, maxLongitude);
    }

    public Coordinate findMinimumCoordinate() {
        double minLatitude = Double.MAX_VALUE;
        double minLongitude = Double.MAX_VALUE;
        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLatitude() < minLatitude) {
                minLatitude = trackPoint.getCoordinate().getLatitude();
            }
            if (trackPoint.getCoordinate().getLongitude() < minLongitude) {
                minLongitude = trackPoint.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minLatitude, minLongitude);
    }

    public double getDistance() {
        double sumDistance = 0.0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            sumDistance += trackPoints.get(i).getDistanceFrom(trackPoints.get(i + 1));
        }
        return sumDistance;
    }

    public double getFullDecrease() {
        double sumDecrease = 0.0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            double elevation1 = trackPoints.get(i).getElevation();
            double elevation2 = trackPoints.get(i + 1).getElevation();
            if (elevation1 > elevation2) {
                sumDecrease += elevation1 - elevation2;
            }
        }
        return sumDecrease;
    }

    public double getFullElevation() {
        double sumElevation = 0.0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            double elevation1 = trackPoints.get(i).getElevation();
            double elevation2 = trackPoints.get(i + 1).getElevation();
            if (elevation1 < elevation2) {
                sumElevation += elevation2 - elevation1;
            }
        }
        return sumElevation;
    }

    public double getRectangleArea() {
        Coordinate maxCoordinate = findMaximumCoordinate();
        Coordinate minCoordinate = findMinimumCoordinate();
        return (maxCoordinate.getLatitude() - minCoordinate.getLatitude()) *
                (maxCoordinate.getLongitude() - minCoordinate.getLongitude());
    }

    public void loadFromGpx(InputStream inputStream) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            Coordinate coordinate = null;

            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("<trkpt")) {
                    coordinate = lineToCoordinate(line);
                }
                if (line.contains("<ele") && coordinate!=null) {
                    addTrackPoint(new TrackPoint(coordinate, lineToElevation(line)));
                    coordinate = null;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }

    private Coordinate lineToCoordinate(String line) {
        String data[] = line.split(Character.toString(34));
        double latitude = Double.parseDouble(data[1]);
        double longitude = Double.parseDouble(data[3]);
        return new Coordinate(latitude, longitude);
    }

    private double lineToElevation(String line) {
        String data = line.substring(line.indexOf('>') + 1, line.lastIndexOf('<'));
        return Double.parseDouble(data);
    }
}
