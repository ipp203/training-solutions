package week13.d03;

import java.util.*;

public class Books {
    private Map<String, Integer> authors = new HashMap<>();

    public Books(List<Book> books) {
        for (Book book : books) {
            if (!authors.containsKey(book.getAuthor())) {
                authors.put(book.getAuthor(), book.getNumberOfPages());
            } else {
                String key = book.getAuthor();
                authors.put(key, authors.get(key) + book.getNumberOfPages());
            }
        }
    }

    public String getMostPagesAuthor() {
        String result = "";
        int maxPages = 0;
        for (Map.Entry<String, Integer> author : authors.entrySet()) {
            if (author.getValue() > maxPages) {
                maxPages = author.getValue();
                result = author.getKey();
            }
        }
        return result;
    }
}
