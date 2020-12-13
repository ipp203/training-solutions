package week06.d02;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products;
    private List<Category> categories;

    public Store(List<Product> products) {
        this.products = products;
        categories = new ArrayList<>();
        for (Category category : Category.values()) {
            categories.add(category);
        }
    }

    public List<Category> getProductsByCategory() {
        for (Product product : products) {
            int catOrd = product.getCategory().ordinal();
            categories.get(catOrd).incNumber();
        }
        return List.copyOf(categories);
    }

}
