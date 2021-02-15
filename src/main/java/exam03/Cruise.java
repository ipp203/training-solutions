package exam03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cruise {
    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers;

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
        passengers = new ArrayList<>();
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

    public void bookPassenger(Passenger passenger) {
        validatePassenger(passenger);

        if (boat.getMaxPassengers() > passengers.size()) {
            passengers.add(passenger);
        } else {
            throw new IllegalArgumentException("The boat is full!");
        }
    }

    public double getPriceForPassenger(Passenger passenger) {
        validatePassenger(passenger);
        return basicPrice * passenger.getCruiseClass().getExtraRate();
    }

    public Passenger findPassengerByName(String name) {
        validateName(name);

        Optional<Passenger> o = passengers.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();

        if (o.isPresent()) {
            return o.get();
        }
        throw new IllegalArgumentException("Booking list is not contain this name: " + name);
    }

    public List<String> getPassengerNamesOrdered() {
        return passengers.stream()
                .map(Passenger::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public double sumAllBookingsCharged() {
        return passengers.stream()
                .mapToDouble(this::getPriceForPassenger)
                .sum();
    }

    public Map<CruiseClass, Long> countPassengerByClass() {

        return passengers.stream()
                .collect(Collectors.groupingBy(Passenger::getCruiseClass, Collectors.counting()));
    }

    private void validatePassenger(Passenger passenger) {
        if (passenger == null || passenger.getCruiseClass() == null) {
            throw new IllegalArgumentException("Passenger or cruise class is null!");
        }
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is null or empty!");
        }
    }
}
