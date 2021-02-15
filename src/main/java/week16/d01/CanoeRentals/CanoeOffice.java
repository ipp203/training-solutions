package week16.d01.CanoeRentals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CanoeOffice {
    private List<CanoeRental> rentals = new ArrayList<>();

    public int getNumberOfRental() {
        return rentals.size();
    }

    public void createRental(CanoeRental rental) {
        rentals.add(rental);
    }


    public Optional<CanoeRental> findRentalByName(String name) {
        for (CanoeRental rental : rentals) {
            if (rental.getName().equals(name) && rental.isActive()) {
                return Optional.of(rental);
            }
        }
        return Optional.empty();
    }

    public void closeRentalByName(String name, LocalDateTime endTime) {
        Optional<CanoeRental> o = findRentalByName(name);
        if (o.isPresent()) {
            o.get().setEndTime(endTime);
        }
    }

    public double getRentalPriceByName(String name, LocalDateTime endTime) {
        Optional<CanoeRental> o = findRentalByName(name);
        if (o.isPresent()) {
            return o.get().calculateRentalTo(endTime);
        }
        return 0.0;
    }

    public List<CanoeRental> listClosedRentals() {
        return rentals.stream()
                .filter(r -> !r.isActive())
                .sorted()
                .collect(Collectors.toList());
    }

    public Map<CanoeType, Long> countRentals() {
        return rentals.stream()
                .collect(Collectors.groupingBy(CanoeRental::getCanoeType, Collectors.counting()));
    }
}
