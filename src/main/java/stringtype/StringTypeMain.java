package stringtype;

public class StringTypeMain {
    public static void main(String[] args) {
        String prefix = "Hello";
        String name = "Jhon Doe";
        String message = prefix+" "+name;
        message = message + 444;
        boolean b = message.equals("Hello Jhon Doe");
        boolean c = message.equals("Hello Jhon Doe444");
        System.out.println(b);
        System.out.println(c);
        System.out.println((""+"").length());

        String s = "Abcde";
        System.out.println(s.length());
        System.out.println(s.substring(0,1) + s.substring(2,3));
        System.out.println(s.substring(0,3));

    }
}
