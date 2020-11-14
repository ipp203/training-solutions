package filescanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void loadFromFile() {
        try (Scanner fileScanner = new Scanner(Library.class.getResourceAsStream("/book.csv"))) {
            books = new ArrayList<>();

            String[] dataOfBook = new String[4];

            while (fileScanner.hasNextLine()) {
                try (Scanner lineScanner = new Scanner(fileScanner.nextLine()).useDelimiter(";")) {
                    int i = 0;
                    while (lineScanner.hasNext()) {
                        dataOfBook[i] = lineScanner.next();
                        i++;
                    }
                }
                books.add(new Book(dataOfBook[0],dataOfBook[1],dataOfBook[2],Integer.parseInt(dataOfBook[3])));

            }
        }
    }
}
