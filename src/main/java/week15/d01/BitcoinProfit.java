package week15.d01;

public class BitcoinProfit {
    private int buyDay;
    private int saleDay;
    private int profit;

    public BitcoinProfit(int buyDay, int saleDay, int profit) {
        this.buyDay = buyDay;
        this.saleDay = saleDay;
        this.profit = profit;
    }

    public int getBuyDay() {
        return buyDay;
    }

    public int getSaleDay() {
        return saleDay;
    }

    public int getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return  "buyDay=" + buyDay +
                ", saleDay=" + saleDay +
                ", profit=" + profit ;
    }
}
