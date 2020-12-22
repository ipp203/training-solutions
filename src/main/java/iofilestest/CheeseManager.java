package iofilestest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CheeseManager {

    public void saveToFile(Path path, List<Cheese> cheeseList) {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(Files.newOutputStream(path)))) {

            dos.writeInt(cheeseList.size());
            for (Cheese cheese : cheeseList) {
                dos.writeUTF(cheese.getName());
                dos.writeDouble(cheese.getLactose());
            }

        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not write file", ioe);
        }
    }

    public Cheese findCheese(Path path, String cheeseName) {
        Cheese cheese = null;
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(Files.newInputStream(path)))) {
            int length = dis.readInt();
            for (int i = 0; i < length; i++) {
                cheese = new Cheese(dis.readUTF(), dis.readDouble());
                if (cheese.getName().equals(cheeseName)) {
                    return cheese;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
        return null;
    }

}
