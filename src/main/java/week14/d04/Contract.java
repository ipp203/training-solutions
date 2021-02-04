package week14.d04;

import java.util.ArrayList;
import java.util.List;

public class Contract {
    private String client;
    private List<Integer> monthlyPrices;

    public Contract(String client, List<Integer> monthlyPrices) {
        this.client = client;
        this.monthlyPrices = monthlyPrices;
    }

    public Contract copyContract(String name){
        List<Integer> copyMonthlyPrices = new ArrayList<>(monthlyPrices);
        return new Contract(name,copyMonthlyPrices);
    }

    public String getClient() {
        return client;
    }

    public int getMonthlyPrice(int index) {
        return monthlyPrices.get(index);
    }

    public void setMonthlyPrice(int index,int value){
        monthlyPrices.set(index,value);
    }

}
