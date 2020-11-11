package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryItem {
    private String word;
    private List<String> translations = new ArrayList();

    public DictionaryItem(String word, List<String> translations) {
        this.word = word;
        addTranslation(translations);
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void addTranslation(List<String> translations) {
        for (String str : translations) {
            if (!this.translations.contains(str)) {
                this.translations.add(str);
            }
        }
    }
}
