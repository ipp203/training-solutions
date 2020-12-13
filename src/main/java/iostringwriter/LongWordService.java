package iostringwriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {
    private void writeLongWords(Writer writer, List<String> strings) {
        PrintWriter pw = new PrintWriter(writer);
        for (String str : strings) {
            pw.print(str);
            pw.print(": ");
            pw.println(str.length());
        }
    }


    public String writeWithStringWriter(List<String> strings) {
        StringWriter sw = new StringWriter();
        try (sw) {
            writeLongWords(sw, strings);
            return sw.toString();
        } catch (IOException ioe) {
            throw new IllegalStateException("", ioe);
        }
    }
}
