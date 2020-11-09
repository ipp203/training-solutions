package enumtype.unit;

import java.util.ArrayList;
import java.util.List;

public class UnitConverter {
    private final static double ROUNDER = 10000.0;

    public double convert(double length, LengthUnit source, LengthUnit target) {
        double exchange = source.getInMM() / target.getInMM();
        return Math.round(ROUNDER * length * exchange) / ROUNDER;
    }

    public List<LengthUnit> siUnits() {
        List<LengthUnit> lengthUnitList = new ArrayList<>();
        for (LengthUnit lu : LengthUnit.values()) {
            if (lu.isSi()) {
                lengthUnitList.add(lu);
            }
        }
        return lengthUnitList;
    }
}
