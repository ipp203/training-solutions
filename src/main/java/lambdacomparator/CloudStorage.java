package lambdacomparator;

public class CloudStorage implements Comparable<CloudStorage> {
    public static final int BASIC_SPACE = 1000;
    private String provider;
    private int space;
    private double price;
    private PayPeriod period;

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
        period = null;
        price = 0;
    }

    public CloudStorage(String provider, int space, PayPeriod period, double price) {
        this.provider = provider;
        this.space = space;
        this.price = price;
        this.period = period;
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public double getPrice() {
        return price;
    }

    public PayPeriod getPeriod() {
        return period;
    }

    private double getPriceForOneYear() {
        if (price == 0) {
            return 0;
        }
        double priceFor1000GB = price / space * BASIC_SPACE;
        return priceFor1000GB / period.getLength() * PayPeriod.ANNUAL.getLength();
    }

    @Override
    public int compareTo(CloudStorage o) {
        return Double.compare(this.getPriceForOneYear(), o.getPriceForOneYear());
    }
}
