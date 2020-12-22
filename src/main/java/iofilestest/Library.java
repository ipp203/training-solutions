package iofilestest;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return List.copyOf(books);
    }

    public void add(Book... books) {
        for (Book book : books) {
            if (!isInBookList(book)) {
                this.books.add(book);
            }
        }
    }

    public void saveBooks(Path path) {
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(path))) {
            for (Book book : books) {
                pw.println(book);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not write file");
        }
    }

    public void loadBooks(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] data = line.split(":");
                add(new Book(data[0], data[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not write file");
        }
    }

    private boolean isInBookList(Book book) {
        for (Book b : books) {
            if (b.getTitle().equals(book.getTitle()) && b.getAuthor().equals(book.getAuthor())) {
                return true;
            }
        }
        return false;
    }
}
