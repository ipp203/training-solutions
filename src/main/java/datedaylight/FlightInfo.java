package datedaylight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FlightInfo {
    ZonedDateTime departureDateTime;

    public FlightInfo(String dateString, String pattern, Locale locale, ZoneId zone) {
        isStringValid(dateString, "date");
        isStringValid(pattern, "pattern");
        isParNull(locale, "Locale");
        isParNull(zone, "zoneId");
        departureDateTime = ZonedDateTime.of(
                LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(pattern, locale)),
                zone);
    }

    public ZonedDateTime getArrivalDateTime(ZoneId zone, int flightHours, int flightMinutes) {
        ZonedDateTime result = departureDateTime.plusHours(flightHours).plusMinutes(flightMinutes);
        return result.withZoneSameInstant(zone);
    }

    public ZonedDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    private void isStringValid(String str, String id) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("Empty " + id + " string parameter!");
        }
    }

    private void isParNull(Object o, String id) {
        if (o == null) {
            throw new NullPointerException(id + " must not be null!");
        }
    }
}
