package week15.d01;

import java.util.List;

public class Bitcoins {
    private List<Integer> rates;

    public BitcoinProfit findMaxProfit(List<Integer> rates) {
        this.rates = rates;
        BitcoinProfit result = new BitcoinProfit(0, 0, Integer.MIN_VALUE);
        int actualMin = Integer.MAX_VALUE;
        for (int i = 0; i < rates.size() - 1; i++) {
            if (actualMin > rates.get(i)) {
                actualMin = rates.get(i);
                getMaxProfit(i, result);
            }
        }
        return result;
    }

    private void getMaxProfit(int i, BitcoinProfit bp) {
        for (int j = i + 1; j < rates.size(); j++) {
            int profit = rates.get(j) - rates.get(i);
            if (profit > bp.getProfit()) {
                bp.setNewValues(i + 1, j + 1, profit);
            }
        }
    }

}
