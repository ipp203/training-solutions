package week13.d04;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TemplateEngineTest {
    @Test
    void testMerge() {
        TemplateEngine te = new TemplateEngine();
        StringWriter sw = new StringWriter();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        TemplateEngineTest.class.getResourceAsStream("template.txt")));
             BufferedWriter bw = new BufferedWriter(sw))
        {
            Map<String, Object> data = Map.of(
                    "nev", "John Doe",
                    "datum", LocalDate.of(2021, 1, 28),
                    "osszeg", 100_000L,
                    "hatarido", LocalDate.of(2021, 2, 28));

            te.merge(br, data, bw);
        } catch (IOException | NullPointerException ionpe) {
            System.out.println(ionpe.getMessage());
        }
        String[] lines = sw.toString().split("\r\n");
        assertEquals("Doe!",lines[0].substring(lines[0].length()-4));
        System.out.println(sw.toString());
    }

}