package enumtype.unit;

public class UnitConverterMain {
    public static void main(String[] args) {
        UnitConverter unitConverter = new UnitConverter();

        System.out.println(unitConverter.convert(1000, LengthUnit.METER, LengthUnit.MILLIMETER));
        System.out.println(unitConverter.convert(1, LengthUnit.INCH, LengthUnit.METER));
        System.out.println(unitConverter.convert(10, LengthUnit.YARD, LengthUnit.FOOT));
        System.out.println(unitConverter.convert(1000, LengthUnit.METER, LengthUnit.YARD));
        System.out.println(unitConverter.convert(1, LengthUnit.YARD, LengthUnit.METER));

        for (LengthUnit lu : LengthUnit.values()) {
            System.out.print(lu.name() + ", ");
        }
        System.out.println();

        System.out.println("SI units: " + unitConverter.siUnits().toString());

    }
}
