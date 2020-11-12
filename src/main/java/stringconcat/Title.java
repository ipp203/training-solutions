package stringconcat;

public enum Title {
    MR("Mr."), MS("Ms."), DR("Dr.");
    private String titleString;

    Title(String titleString) {
        this.titleString = titleString;
    }

    public String getTitleString() {
        return titleString;
    }
}
