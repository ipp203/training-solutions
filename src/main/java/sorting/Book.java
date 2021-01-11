package sorting;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private final int id;
    private final String title;
    private final String author;

    public Book(int regNumber, String author, String title) {
        this.id = regNumber;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title.strip();
    }

    public String getAuthor() {
        return author.strip();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(Book o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "" + getId() + " " + getAuthor() + " " + getTitle();
    }
}

