package week07.d05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {
    Scanner scanner;

    public SaveInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readLines() {
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Add meg az " + (i + 1) + ". sort!");
            String line = scanner.nextLine();
            lines.add(line);
        }
        return lines;
    }

    public Path readFileName() {
        System.out.println("Add meg a fájl nevét!");
        String fileName = scanner.nextLine();
        return Path.of(fileName); //project gyokerebe teszi
    }

    public void write(Path path, List<String> lines) throws IOException {
        Files.write(path, lines);
    }

}
