package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogParser {

    public static final int NUMBER_OF_FIELDS = 3;
    public static final String FILED_SEPARATOR = ":";
    public static final String LINE_SEPARATOR = "\n";
    public static final int INDEX_OF_IP = 0;
    public static final int INDEX_OF_DATE = 1;
    public static final int INDEX_OF_LOGIN = 2;


    public Map<String, List<Entry>> parseLog(String log) {
        isEmpty(log);

        String[] lines = log.split(LINE_SEPARATOR);
        isAnyLineInLog(lines);

        Map<String, List<Entry>> map = new HashMap<>();

        for (String line : lines) {
            Entry entry = lineToEntry(line.split(FILED_SEPARATOR));
            String ipAddress = entry.getIpAddress();
            if (map.containsKey(ipAddress)) {
                (map.get(ipAddress)).add(entry);
            } else {
                List<Entry> entryList = new ArrayList<>();
                entryList.add(entry);
                map.put(ipAddress, entryList);
            }
        }
        return map;
    }

    private void isEmpty(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("Incorrect log: Log is empty or null");
        }
    }

    private void isAnyLineInLog(String[] lines) {
        if (lines.length < 1) {
            throw new IllegalArgumentException("Incorrect log: Not any line in log");
        }
    }

    private LocalDate stringToDate(String str) {
        try {
            return LocalDate.parse(str, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Incorrect log: incorrect date", dtpe);
        }
    }

    private Entry lineToEntry(String[] data) {
        if (data.length != NUMBER_OF_FIELDS) {
            throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
        }
        String ipAddress = data[INDEX_OF_IP];
        LocalDate entryDate = stringToDate(data[INDEX_OF_DATE]);
        String login = data[INDEX_OF_LOGIN];
        return new Entry(entryDate, ipAddress, login);
    }
}
