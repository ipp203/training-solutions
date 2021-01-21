package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("What is the name of the product?");
        String name = scn.nextLine();
        System.out.println("How much is the price of the product?");
        int price = scn.nextInt();
        Product product = new Product(name,price);

        product.decreasePrice(100);
        System.out.println(product.getName() + "'s price is " + product.getPrice());

        product.increasePrice(50);
        System.out.println(product.getName() + "'s price is " + product.getPrice());
    }
}
