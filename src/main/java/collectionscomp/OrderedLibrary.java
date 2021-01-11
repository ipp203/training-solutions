package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {
    private List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByRegNumb(){
        Collections.sort(libraryBooks);
        return libraryBooks;
    }

    public List<Book> orderedByTitle() {
        Collections.sort(libraryBooks, new Comparator<>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return libraryBooks;
    }

    public List<Book> orderedByAuthor() {
        Collections.sort(libraryBooks, new AuthorComparator());
        return libraryBooks;
    }

    public List<String> orderedByTitleLocale(Locale locale) {
        List<String> titles = new ArrayList<>();
        for (Book book : libraryBooks) {
            titles.add(book.getTitle());
        }
        Collections.sort(titles, Collator.getInstance(locale));
        return titles;
    }
}
