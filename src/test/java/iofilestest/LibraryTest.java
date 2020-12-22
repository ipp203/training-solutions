package iofilestest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @TempDir
    public Path folder;

    @Test
    void testLibraryAdd() {
        //Given
        Library library = new Library();

        //When
        library.add(new Book("Aaaa Aaaaaa", "Bbbbb bbbbbbb"),
                new Book("Cccc Cccccc", "Ddddd ddddddd"),
                new Book("Eeee Eeeeee", "Fffff fffffff"),
                new Book("Eeee Eeeeee", "Fffff fffffff"));

        //Then
        assertEquals(3, library.getBooks().size());

    }

    @Test
    void testLibraryFile() {
        //Given
        Library library = new Library();
        Library library1 = new Library();

        //When
        library.add(new Book("Aaaa Aaaaaa", "Bbbbb bbbbbbb"),
                new Book("Cccc Cccccc", "Ddddd ddddddd"),
                new Book("Eeee Eeeeee", "Fffff fffffff"),
                new Book("Eeee Eeeeee", "Fffff fffffff"));

        library.saveBooks(folder.resolve("library.txt"));

        library1.loadBooks(folder.resolve("library.txt"));

        List<Book> books = library.getBooks();
        List<Book> books1 = library1.getBooks();

        //Then
        assertEquals(books.size(), books1.size());
        assertEquals(books.get(1).getAuthor(), books1.get(1).getAuthor());
    }
}