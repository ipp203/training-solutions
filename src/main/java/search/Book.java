package search;

import java.util.Objects;

public class Book implements Comparable<Book>{
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
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public int compareTo(Book o) {
        if (this.author.equals(o.author)){
            return this.title.compareTo(o.title);
        }
        return this.author.compareTo(o.author);
    }

    @Override
    public String toString() {
        return "" + id +" " + author + " " + title;
    }
}

