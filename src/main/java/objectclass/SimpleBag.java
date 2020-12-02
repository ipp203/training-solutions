package objectclass;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {
    private List<Object> items;
    private int cursor;

    public SimpleBag() {
        items = new ArrayList<>();
        beforeFirst();
    }

    public void putItem(Object item) {
        items.add(item);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public void beforeFirst() {
        cursor = -1;
    }

    public boolean hasNext() {
        return items.size() > cursor + 1;
    }

    public Object next() {
        return items.get(++cursor);
    }

    public boolean contains(Object item) {
        for (Object obj : items) {
            if (obj.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public int getCursor() {
        return cursor;
    }
}
