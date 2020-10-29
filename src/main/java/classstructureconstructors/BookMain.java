package classstructureconstructors;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("Jack London", "The Call of the Wild");
        book.register(1903);
        System.out.println(book.getAuthor() + ": " + book.getTitle() +
                ", regNumb: " + book.getRegNumber());

    }
}
