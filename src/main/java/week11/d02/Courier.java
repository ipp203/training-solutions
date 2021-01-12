package week11.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Courier {

    private List<Ride> rideList = new ArrayList<>();

    public void loadRideFromFile(InputStream inputStream) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                rideList.add(lineToRide(line));
            }
            Collections.sort(rideList);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        if (rideList.isEmpty()) {
            throw new IllegalStateException("File is empty");
        }
    }

    private Ride lineToRide(String line) {
        String[] data = line.split(" ");
        if (data.length != 3) {
            throw new IllegalStateException("Unknown file data");
        }
        int day = Integer.parseInt(data[0]);
        int index = Integer.parseInt(data[1]);
        int distance = Integer.parseInt(data[2]);
        return new Ride(day, index, distance);
    }

    public Ride getFirstRideAWeek() {
        return rideList.get(0);
    }

    public List<Integer> getFreeDays() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            result.add(i + 1);
        }
        for (Ride ride : rideList) {
            result.remove((Integer) ride.getDay());
        }
        return result;
    }

    public int[] getDailyDistance() {
        int[] result = new int[7];
        for (Ride ride : rideList) {
            result[ride.getDay() - 1] += ride.getDistance();
        }
        return result;
    }
}
