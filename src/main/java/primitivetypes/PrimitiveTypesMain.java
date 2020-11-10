package primitivetypes;

public class PrimitiveTypesMain {
    public static void main(String[] args) {
        PrimitiveTypes primitiveTypes = new PrimitiveTypes();

        System.out.println(primitiveTypes.toBinaryString(123) + " (" +
                primitiveTypes.toBinaryString(123).length() + ")");
        System.out.println(Integer.toBinaryString(123));
        System.out.println(primitiveTypes.toBinaryString(123).equals(Integer.toBinaryString(123)));

        Integer a = 1;
        Integer b = 2;
        System.out.println(a + b);

    }
}
