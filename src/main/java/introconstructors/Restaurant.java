package introconstructors;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<String> menu;
    private String name;
    private int capacity;

    public Restaurant(String name, int numberOfTables) {
        this.name = name;
        capacity = 4 * numberOfTables;
        setMenu();
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    private void setMenu(){
        menu = new ArrayList<>();
        menu.add("Tokfozelek");
        menu.add("Babfozelek");
        menu.add("Lencsefozelek");
        menu.add("Borsofozelek");
        menu.add("Kaposztafozelek");

    }

}
