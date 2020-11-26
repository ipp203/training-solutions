package defaultconstructor;

public class SimpleDateFormatter {
    private CountryCode defaultCountryCode;


    public SimpleDateFormatter() {
        defaultCountryCode = CountryCode.HU;
    }

    public String formatDateString(SimpleDate simpleDate) {
        return formatDateStringByCountryCode(defaultCountryCode, simpleDate);
    }

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {
        if (simpleDate == null || countryCode == null) {
            throw new IllegalArgumentException("Illegal argument.");
        }
        switch (countryCode) {
            case HU:
                return String.format("%d-%d-%d", simpleDate.getYear(), simpleDate.getMonth(), simpleDate.getDay());
            case EN:
                return String.format("%d-%d-%d", simpleDate.getDay(), simpleDate.getMonth(), simpleDate.getYear());
            case US:
                return String.format("%d-%d-%d", simpleDate.getMonth(), simpleDate.getDay(), simpleDate.getYear());
        }
        return "";
    }
}
