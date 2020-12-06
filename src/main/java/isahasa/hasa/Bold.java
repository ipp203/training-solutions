package isahasa.hasa;

import isahasa.TextSource;

public class Bold extends TextDecorator {

    public Bold(TextSource textSource) {
        super(textSource);
    }

    @Override
    public String getPlainText() {
        return "<b>" + super.getTextSource().getPlainText() + "</b>";
    }
}
