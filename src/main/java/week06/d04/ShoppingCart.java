package week06.d04;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();

    public void addItem(String name, int quantity) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Name can not be empty!");
        }

        Item item = findItemByName(name);
        if (item == null) {
            items.add(new Item(name, quantity));
        } else {
            item.incQuantity(quantity);
        }
    }

    public int getItem(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Name can not be empty!");
        }

        Item item = findItemByName(name);
        return item == null ? 0 : item.getQuantity();
    }

    private Item findItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

}
