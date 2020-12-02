package objectclass;

public class Book {
    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String toString() {
        return author + ": " + title;
    }

    @Override
    public boolean equals(Object o) {// generált metódus!
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }

        Book book = (Book) o;
        boolean result;

        if (author == null) {
            result = book.author == null;
        } else {
            result = author.equals(book.author);
        }

        if (title == null) {
            result = result && book.title == null;
        } else {
            result = result && title.equals(book.title);
        }
        return result;

    }
}
