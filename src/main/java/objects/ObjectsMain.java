package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {
    public static void main(String[] args) {
        class Book {

        }
        new Book();
        System.out.println(new Book());

        System.out.println("-------emptyBook--------");
        Book emptyBook = null;
        System.out.println(emptyBook);
        System.out.println(emptyBook == null);

        System.out.println("-------book--------");
        Book book = new Book();
        System.out.println(book);
        book = null;
        System.out.println(book);
        book = new Book();
        System.out.println(book);

        System.out.println("-------anotherBook--------");
        Book anotherBook = new Book();
        System.out.println(anotherBook == book);
        anotherBook = book;
        System.out.println(anotherBook);
        System.out.println(anotherBook == book);
        System.out.println(anotherBook instanceof Book);

        Book[] bookArray = {new Book(), new Book(), new Book()};
        List<Book> bookList = Arrays.asList(new Book(), new Book(), new Book());
        List<Book> emptyBookList = new ArrayList<>();
        emptyBookList.add(new Book());
        emptyBookList.add(new Book());
        emptyBookList.add(new Book());

    }
}
