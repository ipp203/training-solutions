package week16.d01.VowelsFilter;

import java.io.BufferedReader;
import java.io.IOException;

public class VowelFilter {

    private static final String VOWELS = "aáeéiíoóöőuúüűAÁEÉIÍOÓÖŐUÚÜŰ";

    public String filterVowels(BufferedReader reader) {
        if (reader == null) {
            throw new IllegalArgumentException("Reader is null");
        }

        StringBuilder result = new StringBuilder();
        try (reader) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(filterLine(line));
                result.append("\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        return result.toString().strip();
    }

    private String filterLine(String line) {
        char[] chars = line.toCharArray();
        StringBuilder result = new StringBuilder();
        for (Character c : chars) {
            if (!VOWELS.contains(c.toString())) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
