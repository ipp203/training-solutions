package activity;

public class Coordinate {
    private final double latitude;
    private final double longitude;

    public Coordinate(double latitude, double longitude) {
        if (latitude<-90 || latitude>90){
            throw new IllegalArgumentException("Latitude not valid (-90<=latitude<=90)");
        }
        if (longitude<-180 || longitude>180){
            throw new IllegalArgumentException("Longitude not valid (-180<=longitude<=180)");
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
