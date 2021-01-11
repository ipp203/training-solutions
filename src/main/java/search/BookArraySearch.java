package search;

import java.util.Arrays;

public class BookArraySearch {
    private Book[] bookArray;

    public BookArraySearch(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book findBookByAuthorTitle(String author, String title){
        isValid(author,title);
        Arrays.sort(bookArray);

        int index = Arrays.binarySearch(bookArray,new Book(0,author,title));
        if (index<0){
            throw new IllegalArgumentException("No book found by " + author + " with title " + title);
        }
        return bookArray[index];
    }

    private void isValid(String author,String title){
        if (author == null || author.isBlank() || title == null || title.isBlank()){
            throw new IllegalArgumentException("Author or title must not be empty!");
        }
    }

}
