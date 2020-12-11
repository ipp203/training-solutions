package week07d05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SaveInputTest {
    @TempDir
    public Path tempDirectory;

    @Test
    void testRead() {
        Scanner scanner = new Scanner("aaa\nbbb\nccc\nalma.txt\n");
        SaveInput saveInput = new SaveInput(scanner);

        List<String> lines = saveInput.readLines();
        assertEquals(List.of("aaa", "bbb", "ccc"), lines);

        assertEquals(Path.of("alma.txt"), saveInput.readFileName());

    }

    @Test
    void testWrite() throws IOException {
        Scanner scanner = new Scanner(System.in);
        SaveInput saveInput = new SaveInput(scanner);

        //System.out.println(tempDirectory);

        Path path = Path.of(tempDirectory.toString(), "alma.txt");
        List<String> lines = List.of("aaa", "bbb", "ccc");

        saveInput.write(path, lines);
        String line = Files.readString(path);
        assertEquals("aaa\r\nbbb\r\nccc\r\n", line);

    }
}