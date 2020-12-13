package week07.d04;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class ShoppingList {
    public long calculateSum(String path) {
        long result = 0;
        try (Scanner scanner = new Scanner(Path.of(path), StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(";");
                result += Integer.parseInt(data[1]) * Integer.parseInt(data[2]);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found " + path);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Wrong number format");
        }
        return result;
    }

    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList();

        System.out.println(shoppingList.calculateSum("d:/shoppinglist.txt"));
    }
}
