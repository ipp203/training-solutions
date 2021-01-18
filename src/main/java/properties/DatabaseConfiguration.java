package properties;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class DatabaseConfiguration {
    private Properties properties = new Properties();

    public DatabaseConfiguration() {
        try (InputStreamReader isr = new InputStreamReader(
                             DatabaseConfiguration.class.getResourceAsStream("db.properties"), StandardCharsets.UTF_8)) {
            properties.load(isr);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    public DatabaseConfiguration(File file) {
        try (InputStreamReader isr = new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8)) {
            properties.load(isr);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }

    }

    public String getHost() {
        return properties.getProperty("db.host");
    }

    public int getPort() {
        return Integer.parseInt(properties.getProperty("db.port"));
    }

    public String getSchema() {
        return properties.getProperty("db.schema");
    }
}
