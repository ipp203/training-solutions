package lambdacollectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cafe {
    private List<CoffeeOrder> coffeeOrders;

    public Cafe(List<CoffeeOrder> coffeeOrders) {
        this.coffeeOrders = coffeeOrders;
    }

    public Map<CoffeeType, Long> getCountByCoffeeType() {
        return coffeeOrders.stream()
                .flatMap(co -> co.getCoffeeList().stream())
                .collect(Collectors.groupingBy(Coffee::getType,
                        Collectors.counting()));
    }
    //az eladott kávék mennyiségét adja vissza kávétípusonként

    double getAverageOrder() {
        return coffeeOrders.stream()
                .collect(Collectors.averagingInt(co -> co.getCoffeeList().size()));
    }
    //átlagosan hány kávét rendelnek egyszerre
}
