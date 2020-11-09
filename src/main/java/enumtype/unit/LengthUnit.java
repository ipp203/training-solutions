package enumtype.unit;

/**
 * Mértékegységek
 * <p>
 * Legyen egy enumtype.unit.LengthUnit enum, mely tartalmazza a milliméter, centiméter, méter, yard, foot és inch mértékegységeket.
 * Mindegyik tartalmazza, hogy SI mértékegység-e, valamint hogy egy egység mennyi milliméterre átváltva.
 * <p>
 * Írj a UnitConverter osztályban egy BigDecimal convert(BigDecimal length, LengthUnit source, LengthUnit target) metódust,
 * mely átváltja a paraméterként megkapott értéket, melynek meg van adva a mértékegysége a cél mértékegységre!
 * Először váltsd át milliméterre, majd vissza a cél mértékegységre! Négy tizedesjegyre kell kerekíteni.
 * <p>
 * A List<LengthUnit> siUnits() metódus adja vissza az SI mértékegységeket.
 * <p>
 * A UnitConverterMain main() metódusában próbáld ki a convert() metódust,
 * majd írd ki az összes mértékegységet, valamint csak az SI mértékegységeket!
 */


public enum LengthUnit {
    MILLIMETER(true, 1.0),
    CENTIMETER(true, 10.0),
    METER(true, 1000.0),
    YARD(false, 914.4),
    FOOT(false, 304.8),
    INCH(false, 25.4);

    private final boolean isSi;
    private final double inMM;

    LengthUnit(boolean isSi, double inMM) {
        this.isSi = isSi;
        this.inMM = inMM;
    }

    public boolean isSi() {
        return isSi;
    }

    public double getInMM() {
        return inMM;
    }
}
