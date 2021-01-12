package week11.d02;

import java.util.Objects;

public class Ride implements Comparable<Ride> {
    private final int day;
    private final int index;
    private final int distance;

    public Ride(int day, int index, int length) {
        this.day = day;
        this.index = index;
        this.distance = length;
    }

    public int getDay() {
        return day;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Ride o) {
        if (day != o.day) {
            return day - o.day;
        }
        return index - o.index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return day == ride.day && index == ride.index && distance == ride.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, index, distance);
    }
}
