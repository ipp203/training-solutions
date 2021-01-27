package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private List<CoffeeOrder> coffeeOrders;

    public Cafe(List<CoffeeOrder> coffeeOrders) {
        this.coffeeOrders = coffeeOrders;
    }

    public BigDecimal getTotalIncome() {
        BigDecimal result = coffeeOrders.stream()
                .flatMap(l -> l.getCoffeeList().stream())
                .map(Coffee::getPrice)
                .reduce(new BigDecimal(0), BigDecimal::add);
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalIncome(LocalDate date) {
        BigDecimal result = coffeeOrders.stream()
                .filter(co -> co.getDateTime().toLocalDate().equals(date))
                .flatMap(l -> l.getCoffeeList().stream())
                .map(Coffee::getPrice)
                .reduce(new BigDecimal(0), BigDecimal::add);
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    public long getNumberOfCoffee(CoffeeType type) {
        return coffeeOrders.stream()
                .flatMap(l -> l.getCoffeeList().stream())
                .filter(c -> c.getType().equals(type))
                .count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from) {
        return coffeeOrders.stream()
                .filter(co -> co.getDateTime().isAfter(from))
                .collect(Collectors.toList());
    }


    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {
        return coffeeOrders.stream()
                .filter(co -> co.getDateTime().toLocalDate().equals(date))
                .sorted()
                .limit(5)
                .collect(Collectors.toList());
    }
}
