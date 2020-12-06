package isahasa.hasa;

import isahasa.TextSource;

public class Underlined extends TextDecorator {

    public Underlined(TextSource textSource) {
        super(textSource);
    }

    @Override
    public String getPlainText() {
        return "<u>" + super.getTextSource().getPlainText() + "</u>";
    }
}
