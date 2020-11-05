package attributes.book;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("A vadon szava");
        System.out.println(book.getTitle());
        book.setTitle("A falu szava");
        System.out.println(book.getTitle());
    }
}
