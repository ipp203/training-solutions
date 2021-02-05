package week14.d05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class WordsCounterTest {

    @Test
    void countWords1() {
        WordsCounter wc = new WordsCounter();
        Path file = Path.of("hachiko.srt");
        assertEquals(91,wc.countWords1(file,"Hach"));
    }

    @Test
    void countWords2() {
        WordsCounter wc = new WordsCounter();
        Path file = Path.of("hachiko.srt");
        assertEquals(91,wc.countWords2(file,"Hach"));
    }
}