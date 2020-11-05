package finalmodifier;

public class TaxCalculator {
    private static final double AFA = 27.0 / 100.0;

    public double tax(double price) {
        return price * AFA;
    }

    public double priceWithTax(double nettoPrice) {
        return nettoPrice + tax(nettoPrice);
    }

}
