package algorithmsmax.sales;


import java.util.List;

public class SalesAmountMaxSelector {
    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> salespersons) {
        Salesperson salesperson = null;
        for (Salesperson sp : salespersons) {
            if (salesperson == null || sp.getAmount() > salesperson.getAmount()) {
                salesperson = sp;
            }
        }
        return salesperson;
    }
}
