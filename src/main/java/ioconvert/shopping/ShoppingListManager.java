package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {
    public void saveShoppingList(OutputStream outputStream, List<String> shoppingList) {
        try (OutputStreamWriter osw = new OutputStreamWriter(new BufferedOutputStream(outputStream))) {
            for (String str : shoppingList) {
                osw.write(str + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not write outputStream.", ioe);
        }
    }

    public List<String> loadShoppingList(InputStream inputStream) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            List<String> result = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
            return result;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read inputstream.", ioe);
        }
    }
}
