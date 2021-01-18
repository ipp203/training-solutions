package properties;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class JavaTools {

    public static final String NAME_STRING = "name";
    public static final String URL_STRING = "url";
    public static final String DELIMITER = ".";
    private Properties properties = new Properties();

    public JavaTools() {
        try (InputStreamReader isr = new InputStreamReader(
                JavaTools.class.getResourceAsStream("javatools.properties"), StandardCharsets.UTF_8)) {
            properties.load(isr);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public Set<String> getToolKeys() {
        Set<String> keys = properties.stringPropertyNames();
        Set<String> result = new HashSet<>();
        for (String str : keys) {
            result.add(str.substring(0, str.indexOf(DELIMITER)));
        }
        return result;
    }

    public Set<String> getTools() {
        Set<String> result = new HashSet<>();
        Set<String> keys = properties.stringPropertyNames();
        for (String str : keys) {
            if (str.contains(NAME_STRING)) {
                result.add(properties.getProperty(str));
            }
        }
        return result;
    }

    public String getName(String key) {
        return properties.getProperty(key + DELIMITER + NAME_STRING);
    }

    public String getUrl(String key) {
        return properties.getProperty(key + DELIMITER + URL_STRING);
    }
}
