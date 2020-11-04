package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<String> titles = new ArrayList<>();

    public void add(String title) {
        titles.add(title);
    }

    public List<String> findAllByPrefix(String prefix) {
        List<String> hits = new ArrayList<>();
        for (String item : titles) {
            if (item.indexOf(prefix) == 0) {
                hits.add(item);
            }
        }
        return hits;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void removeByPrefix(String prefix) {
        /*for (String item : titles){
            if (item.indexOf(prefix) == 0){
                titles.remove(item);
            }
        }*/
        titles.removeAll(findAllByPrefix(prefix));
    }

    public static void main(String[] args) {
        Books books = new Books();
        books.add("Brumi az óvodában");
        books.add("Béni az óvodában");
        books.add("Brumi az iskolában");
        books.add("Brumi a kertben");
        books.add("Béni az iskolában");
        books.add("Béni a kerben");
        System.out.println(books.getTitles());

        List<String> hitsOfPrefix = books.findAllByPrefix("Brumi");
        System.out.println(hitsOfPrefix);

        books.removeByPrefix("Brumi");
        System.out.println(books.getTitles());
    }
}
