package initializer;

public class Rate {
    private Currency currency;

    private double rate;

    public Rate(Currency currency, double rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public Currency getCurrency() {
        return currency;
    }
}
