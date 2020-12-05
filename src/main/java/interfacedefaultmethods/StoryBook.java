package interfacedefaultmethods;

import java.util.ArrayList;
import java.util.List;

public class StoryBook implements Printable {
    private List<ColoredPage> coloredPages = new ArrayList<>();

    public void addPage(String content, String color) {
        coloredPages.add(new ColoredPage(content, color));
    }

    @Override
    public int getLength() {
        return coloredPages.size();
    }

    @Override
    public String getPage(int pageIndex) {
        return coloredPages.get(pageIndex).getPageContent();
    }

    @Override
    public String getColor(int pageIndex) {
        return coloredPages.get(pageIndex).getColor();
    }
}
