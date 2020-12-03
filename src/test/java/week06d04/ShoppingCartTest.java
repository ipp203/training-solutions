package week06d04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    ShoppingCart shoppingCart;

    @BeforeEach
    void init() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    void createTest() {
        shoppingCart.getItem("tej");
        assertEquals(0, shoppingCart.getItem("tej"));

        shoppingCart.addItem("tej", 5);
        shoppingCart.addItem("virsli", 2);
        shoppingCart.addItem("tej", 2);
        shoppingCart.addItem("kifli", 4);

        assertEquals(7, shoppingCart.getItem("tej"));
        assertEquals(0, shoppingCart.getItem("bejgli"));

    }

    @Test
    void exceptionTestAddItem() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            shoppingCart.addItem(null, 0);
        });
        assertEquals("Name can not be empty!", ex.getMessage());
    }

    @Test
    void exceptionTestGetItem() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            shoppingCart.getItem("");
        });
        assertEquals("Name can not be empty!", ex.getMessage());
    }
}