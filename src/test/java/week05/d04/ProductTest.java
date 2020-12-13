package week05.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void createProductTest() {
        Product product1 = new Product(150, Currency.HUF);
        Product product2 = new Product(150, Currency.USD);

        assertEquals(150.0, product1.convertPrice(Currency.HUF));
        assertEquals(0.5, product1.convertPrice(Currency.USD));

        assertEquals(45000.0, product2.convertPrice(Currency.HUF));
        assertEquals(150.0, product2.convertPrice(Currency.USD));

        System.out.println(product1.convertPrice(Currency.HUF));
        System.out.println(product1.convertPrice(Currency.USD));

        System.out.println(product2.convertPrice(Currency.HUF));
        System.out.println(product2.convertPrice(Currency.USD));


    }

}