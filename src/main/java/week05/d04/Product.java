package week05.d04;

public class Product {
    private long price;
    private Currency currency;

    public Product(long price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    public double convertPrice(Currency currency) {
        return price * this.currency.getRate() / currency.getRate();
    }
}
