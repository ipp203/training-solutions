package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    List<DictionaryItem> dictionaryItems = new ArrayList<>();

    public void addItem(String word, List<String> translations) {
        boolean isInDictionary = false;
        for (DictionaryItem di : dictionaryItems) {
            if (di.getWord().equals(word)) {
                isInDictionary = true;
                di.addTranslation(translations);
            }
        }
        if (!isInDictionary) {
            dictionaryItems.add(new DictionaryItem(word, translations));
        }
    }

    public List<String> findTranslations(String word) {
        for (DictionaryItem di : dictionaryItems) {
            if (di.getWord().equals(word)) {
                return di.getTranslations();
            }
        }
        return new ArrayList<>();
    }
}
