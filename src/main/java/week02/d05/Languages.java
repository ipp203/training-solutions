package week02.d05;

import java.util.Arrays;
import java.util.List;

public class Languages {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Phyton", "JavaScript");

        for (String lang : languages) {
            if (lang.length() > 5) {
                System.out.println(lang);
            }
        }
    }
}
