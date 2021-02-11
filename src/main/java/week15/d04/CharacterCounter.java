package week15.d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterCounter {

    public static final int CODE_OF_SPACE = ' ';

    public Map<CharType, Long> countChar(String file) {
        try (Stream<String> stream = Files.lines(Path.of(file))) {

            return stream.map(String::toLowerCase)
                    .flatMapToInt(String::chars)
                    .filter(i -> i != CODE_OF_SPACE)
                    .mapToObj(CharType::charIntToCharType)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not exists");
        }
    }

}
