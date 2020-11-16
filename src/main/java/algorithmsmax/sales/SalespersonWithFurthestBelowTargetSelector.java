package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {
    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> salespersons) {
        Salesperson salesperson = null;
        for (Salesperson sp : salespersons) {
            if (salesperson == null || sp.getDifferenceFromTarget() < salesperson.getDifferenceFromTarget()) {
                salesperson = sp;
            }
        }
        return salesperson;
    }
}
