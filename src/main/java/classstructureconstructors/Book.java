package classstructureconstructors;

public class Book {
    private String author,title;
    private int regNumber;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getRegNumber() {
        return regNumber;
    }


    public void register(int regNumber){
        this.regNumber = regNumber;
    }
}
