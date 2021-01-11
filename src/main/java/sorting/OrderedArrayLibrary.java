package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedArrayLibrary {
    Book[] bookArray;

    public OrderedArrayLibrary(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book[] sortingById() {
        Book[] myBookArray = Arrays.copyOf(bookArray, bookArray.length);
        Arrays.sort(myBookArray);
        return myBookArray;
    }

    public Book[] sortingByTitle() {
        Book[] myBookArray = Arrays.copyOf(bookArray, bookArray.length);
        Arrays.sort(myBookArray, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return myBookArray;
    }

}
