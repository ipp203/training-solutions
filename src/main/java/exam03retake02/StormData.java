package exam03retake02;

public class StormData {
    enum StationType {
        LED, VCS, FL, AA, OM;
    }

    public static final String COLON = ":";
    public static final char MARK = '"';
    public static final String COMA = ",";

    private long id;
    private String station;
    private Coordinate coord;
    private String description;
    private long level;
    private String groupId;
    private StationType stationType;

    public StormData(long id, String station, Coordinate coord, String description, long level, String groupId, StationType stationType) {
        this.id = id;
        this.station = station;
        this.coord = coord;
        this.description = description;
        this.level = level;
        this.groupId = groupId;
        this.stationType = stationType;
    }

    public StormData(String[] lines) {
        double lat = 0.0;
        double lng = 0.0;

        for (String line : lines) {
            if (line.contains("\"id\"")) {
                id = getLongFromLine(line);
            }
            if (line.contains("\"level\"")) {
                level = getLongFromLine(line);
            }

            if (line.contains("\"allomas\"")) {
                station = getStringFromLine(line);
            }
            if (line.contains("\"description\"")) {
                description = getStringFromLine(line);
            }
            if (line.contains("\"groupId\"")) {
                groupId = getStringFromLine(line);
            }

            if (line.contains("\"lat\"")) {
                lat = getDoubleFromLine(line);
            }
            if (line.contains("\"lng\"")) {
                lng = getDoubleFromLine(line);
            }

            if (line.contains("\"stationType\"")) {
                stationType = StationType.valueOf(getStringFromLine(line));
            }
        }
        coord = new Coordinate(lat, lng);
    }

    private long getLongFromLine(String line) {
        int indexFrom = line.indexOf(COLON) + 2;
        int indexEnd = line.lastIndexOf(COMA);
        return Integer.parseInt(line.substring(indexFrom, indexEnd));
    }

    private double getDoubleFromLine(String line) {
        String data = line.substring(line.indexOf(COLON));
        int indexFrom = data.indexOf(MARK) + 1;
        int indexEnd = data.lastIndexOf(MARK);
        return Double.parseDouble(data.substring(indexFrom, indexEnd));
    }

    private String getStringFromLine(String line) {
        String data = line.substring(line.indexOf(COLON));
        int indexFrom = data.indexOf(MARK) + 1;
        int indexEnd = data.lastIndexOf(MARK);
        return data.substring(indexFrom, indexEnd);
    }

    public long getId() {
        return id;
    }

    public String getStation() {
        return station;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public String getDescription() {
        return description;
    }

    public long getLevel() {
        return level;
    }

    public String getGroupId() {
        return groupId;
    }

    public StationType getStationType() {
        return stationType;
    }
}
