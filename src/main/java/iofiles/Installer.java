package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Installer {
    public void install(String folder) {
        Path target = Path.of(folder);
        if (!Files.exists(target) || !Files.isDirectory(target)) {
            throw new IllegalArgumentException("The given directory doesn't exist");
        }
        try (BufferedReader br = (new BufferedReader(new InputStreamReader(Installer.class.getResourceAsStream("/install/install.txt"))))) {

            String line;
            while ((line = br.readLine()) != null) {
                Path tempTarget = target.resolve(line);
                if (line.charAt(line.length() - 1) == '/') {
                    Files.createDirectories(tempTarget);
                } else {
                    Files.copy(Installer.class.getResourceAsStream("/install/" + line), tempTarget, StandardCopyOption.REPLACE_EXISTING);
                }

            }
        } catch (IOException ioe) {
            throw new IllegalStateException("install.txt could not be read!", ioe);
        }
    }
}
