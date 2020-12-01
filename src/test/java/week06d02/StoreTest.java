package week06d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    @Test
    public void testStore() {
        Store store = new Store(Arrays.asList(
                new Product("AAA", Category.FROZEN, 13),
                new Product("BBB", Category.BAKEDGOODS, 12),
                new Product("CCC", Category.FROZEN, 10)));
        List<Category> categories = store.getProductsByCategory();
        for (Category c : categories) {
            System.out.println(c);
        }

    }
}