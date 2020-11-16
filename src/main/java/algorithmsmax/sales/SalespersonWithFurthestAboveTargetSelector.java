package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {
    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> salespersons) {
        Salesperson salesperson = null;
        for (Salesperson sp : salespersons) {
            if (salesperson == null || sp.getDifferenceFromTarget() > salesperson.getDifferenceFromTarget()) {
                salesperson = sp;
            }
        }
        return salesperson;
    }
}
