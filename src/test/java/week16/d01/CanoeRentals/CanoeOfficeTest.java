package week16.d01.CanoeRentals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week16.d01.CanoeRentals.CanoeOffice;
import week16.d01.CanoeRentals.CanoeRental;
import week16.d01.CanoeRentals.CanoeType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CanoeOfficeTest {
    private CanoeOffice co;

    @BeforeEach
    void init() {
        co = new CanoeOffice();
        co.createRental(new CanoeRental("Joe", CanoeType.GREEN, LocalDateTime.of(2021, 1, 12, 10, 0).toString()));
        co.createRental(new CanoeRental("John", CanoeType.BLUE, LocalDateTime.of(2021, 1, 12, 11, 0).toString()));
        co.createRental(new CanoeRental("Jane", CanoeType.RED, LocalDateTime.of(2021, 1, 12, 12, 0).toString()));
        co.createRental(new CanoeRental("Jim", CanoeType.GREEN, LocalDateTime.of(2021, 1, 12, 13, 0).toString()));
        co.createRental(new CanoeRental("Jack", CanoeType.RED, LocalDateTime.of(2021, 1, 12, 14, 0).toString()));
        co.createRental(new CanoeRental("Joel", CanoeType.BLUE, LocalDateTime.of(2021, 1, 12, 15, 0).toString()));
        co.createRental(new CanoeRental("Jam", CanoeType.BLUE, LocalDateTime.of(2021, 1, 12, 15, 0).toString()));
    }

    @Test
    void testCreateRental() {
        assertEquals(7, co.getNumberOfRental());
    }

    @Test
    void testFindRentalByName() {
        assertEquals("Jane", co.findRentalByName("Jane").get().getName());
        assertFalse(co.findRentalByName("Bill").isPresent());
    }

    @Test
    void testCloseRentalByName() {
        co.closeRentalByName("Joel", LocalDateTime.of(2021, 1, 12, 19, 0));
        assertFalse(co.findRentalByName("Joel").isPresent());
    }

    @Test
    void getRentalPriceByName() {

        Double result = co.getRentalPriceByName("Joel", LocalDateTime.of(2021, 1, 12, 19, 31));
        assertEquals(30000, result, 0.000001);
        result = co.getRentalPriceByName("Joel", LocalDateTime.of(2021, 1, 11, 19, 31));
        assertEquals(0, result, 0.000001);

    }

    @Test
    void listClosedRentals() {
        co.closeRentalByName("Joel", LocalDateTime.of(2021, 1, 12, 19, 0));
        co.closeRentalByName("Jane", LocalDateTime.of(2021, 1, 12, 19, 0));
        co.closeRentalByName("Jim", LocalDateTime.of(2021, 1, 12, 19, 0));
        List<CanoeRental> closedRentals = co.listClosedRentals();

        assertEquals(3, closedRentals.size());

    }

    @Test
    void countRentals() {
        Map<CanoeType, Long> expected = Map.of(CanoeType.RED, 2L,
                CanoeType.GREEN, 2L,
                CanoeType.BLUE, 3L);

        assertEquals(expected, co.countRentals());
    }
}