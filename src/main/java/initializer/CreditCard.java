package initializer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private long balance;
    private List<Rate> rates;
    private static final List<Rate> ACTUAL_RATES;

    static {
        ACTUAL_RATES = new ArrayList<>();
        ACTUAL_RATES.add(new Rate(Currency.HUF, 1.0));
        ACTUAL_RATES.add(new Rate(Currency.EUR, 308.23));
        ACTUAL_RATES.add(new Rate(Currency.SFR, 289.24));
        ACTUAL_RATES.add(new Rate(Currency.GBP, 362.23));
        ACTUAL_RATES.add(new Rate(Currency.USD, 289.77));
    }

    public CreditCard(int balance) {
        this.balance = balance;
    }

    public CreditCard(long balance, Currency currency, List<Rate> rates) {
        this.rates = rates;
        this.balance = changeToHuf(balance, currency);
    }

    public long getBalance() {
        return balance;
    }

    public boolean payment(int amount) {
        return payment(amount, Currency.HUF);
    }

    public boolean payment(int amount, Currency currency) {
        long amountInHuf = changeToHuf(amount, currency);
        if (balance > amountInHuf) {
            balance -= amountInHuf;
            return true;
        }
        return false;
    }

    private long changeToHuf(long amount, Currency currency) {
        double rate = 1;
        if (rates != null) {
            for (Rate r : rates) {
                if (r.getCurrency() == currency) {
                    rate = r.getRate();
                }
            }
        } else {
            for (Rate r : ACTUAL_RATES) {
                if (r.getCurrency() == currency) {
                    rate = r.getRate();
                }
            }
        }
        return Math.round(amount * rate);
    }
}
