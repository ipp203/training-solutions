package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {
    public List<Integer> find(List<Integer> list) {
        List<Integer> duplicates = new ArrayList<>();

        LIST:
        for (int i = 0; i < list.size(); i++) {
            BeforeI:
            for (int j = 0; j < i; j++) {
                if (list.get(i).equals(list.get(j))) {
                    duplicates.add(list.get(i));
                    break BeforeI;
                }
            }
        }
        return duplicates;
    }
}
