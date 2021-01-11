package sorting;

import java.util.Iterator;
import java.util.Set;

public class OrderedLibrary {
    private Set<Book> library;

    public OrderedLibrary(Set<Book> library) {
        this.library = library;
    }

    public Book lendFirstBook() {
        if (library.isEmpty()) {
            throw new NullPointerException("Libray is empty!");
        }
        Iterator<Book> iterator = library.iterator();

        return iterator.next();
    }
}
