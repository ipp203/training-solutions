package lambdastreams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookStore {
    private List<Book> books;

    public BookStore(List<Book> books) {
        this.books = new ArrayList<>(books);
    }

    public int getNumberOfBooks() {
        return books.stream().reduce(0, (i1, book) -> i1 + book.getNumber(), Integer :: sum);
    }

    public Optional<Book> findNewestBook() {
        //return books.stream().max((b1, b2) -> b1.getYearOfPublish() - b2.getYearOfPublish());
        return books.stream().max(Comparator.comparingInt(Book::getYearOfPublish));
    }

    public int getTotalValue() {
//        return books.stream().reduce(0,
//                (i1, book) -> i1 + book.getNumber() * book.getPrice(),
//                (i1, i2) -> i1 + i2);
        return books.stream().reduce(0,
                (i1, book) -> i1 + book.getNumber() * book.getPrice(),
                Integer::sum);
    }

    public List<Book> getByYearOfPublish(int year) {
        return books.stream().collect(Collectors.groupingBy(Book::getYearOfPublish)).get(year);
    }
}
