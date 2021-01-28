package week13.d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class TemplateEngine {

    public void merge(BufferedReader reader, Map<String, Object> data, BufferedWriter writer) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                line = changeData(data, line);
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read/write file", ioe);
        }
    }

    private String changeData(Map<String, Object> data, String line) {
        int index1;
        while((index1 = line.indexOf("{"))>=0){
            int index2 = line.indexOf("}");
            String key = line.substring(index1 + 1, index2);
            line = line.replace("{" + key + "}", data.get(key).toString());
        }
        return line;
    }


}
