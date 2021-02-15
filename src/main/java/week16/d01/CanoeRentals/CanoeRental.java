package week16.d01.CanoeRentals;

import java.time.Duration;
import java.time.LocalDateTime;

public class CanoeRental implements Comparable<CanoeRental> {
    private String name;
    private CanoeType canoeType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private static final int BASE_PRICE = 5000;

    public CanoeRental(String name, CanoeType canoeType, String dateTimeString) {
        this.name = name;
        this.canoeType = canoeType;
        this.startTime = LocalDateTime.parse(dateTimeString);
    }

    public String getName() {
        return name;
    }

    public CanoeType getCanoeType() {
        return canoeType;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double calculateRentalSum() {
        return canoeType.getValue() * BASE_PRICE;
    }

    public double calculateRentalTo(LocalDateTime endTime) {
        if (startTime.isBefore(endTime)) {
            long hours = Duration.between(startTime, endTime).toHours();
            return canoeType.getValue() * hours * BASE_PRICE;
        }
        return 0.0;
    }

    public boolean isActive() {
        return endTime == null;
    }

    @Override
    public int compareTo(CanoeRental o) {
        return this.startTime.compareTo(o.startTime);
    }
}
