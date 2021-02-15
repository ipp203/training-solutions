package exam03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cruise {
    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers;

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
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

    public void bookPassenger(Passenger passenger){

    }

    public double getPriceForPassenger(Passenger passenger){
        return 0.0;
    }

    public Passenger findPassengerByName(String name){
        return null;
    }

    public List<String> getPassengerNamesOrdered(){
        return null;
    }

    public double sumAllBookingsCharged(){
        return 0.0;
    }

    public Map<CruiseClass,Integer> countPassengerByClass(){
        return null;
    }
}
