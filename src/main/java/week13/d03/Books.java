package week13.d03;

import java.util.*;

public class Books {
    private Map<String, Integer> authors = new HashMap<>();

    public Books(List<Book> books) {
        for (Book book : books) {
            String key = book.getAuthor();
            if (!authors.containsKey(key)) {
                authors.put(key, book.getNumberOfPages());
            } else {
                int sum = authors.get(key);
                authors.put(key, sum + book.getNumberOfPages());
            }
            authors.merge(key,book.getNumberOfPages(),(x,y)->x+y);
        }
    }

    public Optional<String> getMostPagesAuthor() {

        if (authors.isEmpty()){
            return Optional.empty();
        }

        String result = "";
        int maxPages = 0;
        for (Map.Entry<String, Integer> author : authors.entrySet()) {
            if (author.getValue() > maxPages) {
                maxPages = author.getValue();
                result = author.getKey();
            }
        }
        return Optional.of(result);
    }
}
