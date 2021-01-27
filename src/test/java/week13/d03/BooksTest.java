package week13.d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BooksTest {

    @Test
    void getMostPagesAuthorTest() {
        List<Book> books = Arrays.asList(
                new Book("aa", "bb", 10),
                new Book("aa", "bb", 20),
                new Book("ab", "bb", 10),
                new Book("ab", "bb", 10));

        Books books1 = new Books(books);
        assertEquals("aa", books1.getMostPagesAuthor());
    }
}