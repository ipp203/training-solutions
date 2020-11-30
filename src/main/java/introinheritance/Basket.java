package introinheritance;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Item> items;

    public Basket() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return List.copyOf(items);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String barcode) {
        for (Item item : items) {
            if (item.getBarcode().equals(barcode)) {
                items.remove(item);
                return;
            }
        }
    }

    public void clearBasket() {
        items.clear();
    }

}
