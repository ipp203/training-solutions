package filescanner;

public class Book {
    private String regNum, author, title;
    private int yearOfPuplish;

    public Book(String regNum, String author, String title, int yearOfPuplish) {
        this.regNum = regNum;
        this.author = author;
        this.title = title;
        this.yearOfPuplish = yearOfPuplish;
    }

    public String getRegNum() {
        return regNum;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPuplish() {
        return yearOfPuplish;
    }


}
