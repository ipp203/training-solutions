package week02.d03;

public class Product {
    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean areTheyEqual(Product p) {
        int codesLength = code.length() - p.getCode().length();
        codesLength = codesLength > 0 ? codesLength : -codesLength;
        return name.equals(p.getName()) && codesLength <= 1;
    }

    public static void main(String[] args) {
        Product p1 = new Product("Csoki", "1234");
        Product p2 = new Product("Csoka", "1234");
        Product p3 = new Product("Csoki", "123456");

        System.out.println(p1.areTheyEqual(p2));
        System.out.println(p1.areTheyEqual(p3));
        System.out.println(p2.areTheyEqual(p3));
    }
}
