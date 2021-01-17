package collectionsclass;

import java.util.*;

public class CollectionManager {
    private List<Book> library;

    public CollectionManager(List<Book> library) {
        this.library = library;
    }

    //módosíthatatlan listát eredményez
    public List<Book> createUnmodifiableLibrary() {
        return Collections.unmodifiableList(library);
    }

    //az eredeti lista másolatán dolgozik!
    public List<Book> reverseLibrary() {
        List<Book> reversedLibrary = new ArrayList<>(library);
        Collections.reverse(reversedLibrary);
        return reversedLibrary;
    }

    //a legrégebbi (legkisebb id) könyvet adja vissza
    public Book getFirstBook() {
//        List<Book> sortedLibrary = new ArrayList<>(library);
//        Collections.sort(sortedLibrary);
//        return sortedLibrary.get(0);
        return Collections.min(library);
    }

    public Book getLastBook() { // a legújabb (legnagyobb id) könyvet adja vissza
//        List<Book> sortedLibrary = new ArrayList<>(library);
//        Collections.sort(sortedLibrary);
//        Collections.reverse(sortedLibrary);
//        return sortedLibrary.get(0);
        return Collections.max(library);
    }

}
