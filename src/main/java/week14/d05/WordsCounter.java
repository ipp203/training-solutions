package week14.d05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class WordsCounter {

    private String myWord;

    public int countWords1(Path path, String word) {
        myWord = word;

        try (Stream<String> lines = Files.lines(path)) {

            return (int) lines
                    .filter(this::containWord)
                    .flatMap(this::splitLine)
                    .filter(this::containWord)
                    .count();

        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }

    private boolean containWord(String str) {
        return str.contains(myWord);
    }

    private Stream<String> splitLine(String line) {
        return Arrays.stream(line.split(" "));
    }

    public int countWords2(Path path, String word) {
        myWord = word;

        try (Stream<String> lines = Files.lines(path)) {

            return lines
                    .filter(this::containWord)
                    .mapToInt(this::countMyWord)
                    .reduce(0,Integer::sum);

        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }

    private int countMyWord(String line){
        return (int)Arrays.stream(line.split(" "))
                .filter(this::containWord)
                .count();
    }
}
