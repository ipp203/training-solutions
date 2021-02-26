package exam03retake02;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


public class BalatonStorm {
    public static final int STORM_STATION_LINE_NUMBER = 8;
    public static final int STORM_LEVEL = 3;
    private final MariaDbDataSource dataSource;

    public BalatonStorm(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getStationsInStorm(BufferedReader reader) {
        readFile(reader);
        return getStormDataByStormLevel(STORM_LEVEL).stream()
                .map(StormData::getStation)
                .sorted(Collator.getInstance(new Locale("hu", "HU")))
                .collect(Collectors.toList());
    }

    private List<StormData> getStormDataByStormLevel(int stormLevel) {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM balatonstorm WHERE level=?")) {
            pstmt.setLong(1, stormLevel);
            try (ResultSet rs = pstmt.executeQuery()) {

                return processResultSet(rs);

            } catch (SQLException e) {
                throw new IllegalStateException("Can not select", e);
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect", sqle);
        }

    }

    private List<StormData> processResultSet(ResultSet rs) throws SQLException {
        List<StormData> result = new ArrayList<>();
        while (rs.next()) {

            long id = rs.getLong("id");
            String station = rs.getString("station");
            double lat = rs.getDouble("lat");
            double lng = rs.getDouble("lng");
            String desc = rs.getString("description");
            long level = rs.getLong("level");
            String groupId = rs.getString("group_id");
            StormData.StationType stationType = StormData.StationType.valueOf(rs.getString("station_type"));

            result.add(new StormData(id, station, new Coordinate(lat, lng), desc, level, groupId, stationType));
        }
        return result;
    }

    private void readFile(BufferedReader reader) {
        try (reader) {
            String line;
            String[] data = new String[STORM_STATION_LINE_NUMBER];
            int counter = 0;

            while ((line = reader.readLine()) != null) {
                if (line.contains(":")) {
                    if (counter < STORM_STATION_LINE_NUMBER) {
                        data[counter] = line;
                    }
                    counter++;
                } else {
                    if (counter == STORM_STATION_LINE_NUMBER) {
                        saveToDb(new StormData(data));
                    }
                    counter = 0;
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Can not read file", e);
        }
    }

    private void saveToDb(StormData stormData) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO balatonstorm VALUES(?,?,?,?,?,?,?,?)")) {

            pstmt.setLong(1, stormData.getId());
            pstmt.setString(2, stormData.getStation());
            pstmt.setDouble(3, stormData.getCoord().getLat());
            pstmt.setDouble(4, stormData.getCoord().getLng());
            pstmt.setString(5, stormData.getDescription());
            pstmt.setLong(6, stormData.getLevel());
            pstmt.setString(7, stormData.getGroupId());
            pstmt.setString(8, stormData.getStationType().toString());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Can not insert", e);
        }
    }
}
