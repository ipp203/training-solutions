package operators;

public class OperatorsMain {
    public static void main(String[] args) {
        Operators operators = new Operators();
        System.out.println(operators.isEven(12));
        System.out.println(operators.isEven(-12));
        System.out.println(operators.isEven(-11));

        System.out.println("------------");

        System.out.println(operators.multiplyByPoserOfTwo(3, 10));

        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        int j = Long.valueOf(s, 2).intValue();
        //int j = Integer.parseInt(s, 2);
        System.out.println(j);

        System.out.println(0333);//8as szamrendszer
    }
}
