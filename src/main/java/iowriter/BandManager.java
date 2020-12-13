package iowriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {
    private List<Band> bands = new ArrayList<>();


    public void readBandsFromFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                bands.add(new Band(data[0], Integer.parseInt(data[1])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

    }

    public void writeBandsBefore(Path path, int year) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Band band : bands) {
                if (band.getYear() < year) {
                    writer.write(band.getName());
                    writer.newLine();
                }
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }
}
