package collectionsequalshash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {

    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
        Book parBook = new Book(title, author);
        for (Book book : books) {
            if (book.equals(parBook)) {
                return book;
            }
        }
        return null;
    }

    public Book findBook(List<Book> books, Book book) {
        if (books.contains(book)) {
            return book;
        }
        return null;
    }

    public Set<Book> addBooksToSet(Book[] books) {
        Set<Book> result = new HashSet<>();
        for (int i = 0; i < books.length; i++) {
            result.add(books[i]);
        }
        return result;
    }
}
