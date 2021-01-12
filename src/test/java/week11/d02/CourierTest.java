package week11.d02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {
    Courier courier;

    @BeforeEach
    void loadRideFromFile() {
        courier = new Courier();
        courier.loadRideFromFile(this.getClass().getResourceAsStream("rides.txt"));
    }

    @Test
    void getFirstRideAWeek() {
        Ride firstRide = courier.getFirstRideAWeek();
        assertEquals(new Ride(1, 1, 13), firstRide);
    }

    @Test
    void getFreeDays() {
        List<Integer> freeDays = courier.getFreeDays();
        assertEquals(2, freeDays.size());
        assertEquals(2, freeDays.get(0));
    }

    @Test
    void getDailyDistance() {
        int[] dailyDistance = courier.getDailyDistance();
        assertArrayEquals(new int[]{29, 0, 14, 11, 36, 11, 0}, dailyDistance);
    }
}