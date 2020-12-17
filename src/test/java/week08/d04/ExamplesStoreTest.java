package week08.d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExamplesStoreTest {

    @Test
    void testExamplesTitles() {
        //Given
        ExamplesStore es = new ExamplesStore();
        //When
        List<String> examples = es.getTitlesOfExamples("examples.md");
        //Than
        assertEquals(2, examples.size());
        assertArrayEquals(
                new String[]{"Első feladat", "Második feladat"},
                examples.toArray());
    }

}