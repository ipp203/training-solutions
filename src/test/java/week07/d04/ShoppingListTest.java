package week07.d04;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListTest {
    @Test
    void testSum() throws IOException {

        ShoppingList shoppingList = new ShoppingList();
        Path path = Path.of(".").toRealPath();
        long result = shoppingList.calculateSum("src/test/resources/week07d04/list.csv");
        assertEquals(120, result);
    }

}