package week15.d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    Pizza pizza;

    @BeforeEach
    void init() {
        pizza = new Pizza();
        pizza.readFile(Path.of("src/test/resources/week15/d02/orders.txt"));
    }

    @Test
    void testOrdersNumber() {
        assertEquals(17, pizza.getNumberOfOrders());
    }

    @Test
    void testGetMinOrderDay() {
        LocalDate date = pizza.getMinOrderDay();
        assertEquals(LocalDate.of(2020, 12, 3), date);
    }

    @Test
    void testGetOrderByTime() {
        LocalDateTime ldt = LocalDateTime.of(2020, 12, 4, 13, 20);
        Optional<Courier> result = pizza.getOrderByTime(ldt);
        assertTrue(result.isPresent());
        assertEquals(ldt, LocalDateTime.of(result.get().getDate(), result.get().getTime()));
    }

    @Test
    void getCourierStatistics() {
        Map<String, Integer> result = pizza.getCourierStatistics();
        assertEquals(8, result.get("FUT_1"));
    }

    @Test
    void getAddressWithMostPizzas() {
        Address address = new Address("1201", "Petőfi", "3");
        assertEquals(address, pizza.getAddressWithMostPizzas());
    }
}