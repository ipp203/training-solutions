package interfacedefaultmethods;

public class ColoredPage {
    private String pageContent;
    private String color;

    public ColoredPage(String pageContent, String color) {
        this.pageContent = pageContent;
        this.color = color;
    }

    public String getPageContent() {
        return pageContent;
    }

    public String getColor() {
        return color;
    }
}
