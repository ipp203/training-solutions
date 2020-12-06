package isahasa;

public class HtmlText implements TextSource {
    String plainText;

    public HtmlText(String plainText) {
        this.plainText = plainText;
    }

    public String getPlainText() {
        return plainText;
    }
}
