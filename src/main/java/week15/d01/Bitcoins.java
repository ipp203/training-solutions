package week15.d01;

import java.util.List;

public class Bitcoins {

    public BitcoinProfit findMaxProfit(List<Integer> rates){
        int day1 = 0;
        int day2 = 0;
        int maxProfit = 0;
        for (int i = 0; i < rates.size()-1; i++) {
            for (int j = i+1; j <rates.size() ; j++) {
                if(rates.get(j)-rates.get(i)>maxProfit){
                    maxProfit = rates.get(j)-rates.get(i);
                    day1 = i;
                    day2 = j;
                }
            }
        }
        return new BitcoinProfit(day1,day2,maxProfit);
    }

}
