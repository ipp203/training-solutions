package iowritestring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Register {
    public void newMark(Path path, int mark) {
        if (Files.exists(path)) {
            try {
                Files.writeString(path, String.valueOf(mark) + "\n", StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new IllegalStateException("", e);
            }
        } else {
            try {
                Files.writeString(path, String.valueOf(mark) + "\n");
            } catch (IOException e) {
                throw new IllegalStateException("", e);
            }
        }
    }

    public void average(Path path) {
        if (Files.exists(path)) {

            List<Integer> marks = new ArrayList<>();
            try {
                List<String> strs = Files.readAllLines(path);
                for (String mark : strs) {
                    marks.add(Integer.parseInt(mark));
                }
            } catch (IOException | NullPointerException | NumberFormatException e) {
                throw new IllegalStateException("", e);
            }
            try {
                double average = 0.0;
                for (int i : marks) {
                    average += i;
                }
                average /= (double) marks.size();
                Files.writeString(path, String.format("average: %.1f", average), StandardOpenOption.APPEND);
            } catch (IOException | ArithmeticException e) {
                throw new IllegalStateException("", e);
            }
        }
    }
}
