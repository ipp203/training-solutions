package ioprintwriter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {
    private enum Title {
        DR("Dr"), MR("Mr"), MRS("Mrs");
        private String title;

        Title(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    private List<String> names;

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path file) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
            for (String name : names) {
                writer.print(name + ": ");
                writer.println(getSalary(name));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("", ioe);
        }
    }

    private int getSalary(String name) {
        if (name.indexOf(Title.DR.getTitle()) > -1) {
            return 500_000;
        }
        if (name.indexOf(Title.MR.getTitle()) > -1) {
            return 200_000;
        }
        if (name.indexOf(Title.MRS.getTitle()) > -1) {
            return 200_000;
        }
        return 100_000;
    }
}
