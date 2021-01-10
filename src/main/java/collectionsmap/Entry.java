package collectionsmap;

import java.time.LocalDate;

public class Entry {
    private final LocalDate entryDate;
    private final String ipAddress;
    private final String login;

    public Entry(LocalDate entryDate, String ipAdrress, String login) {
        this.entryDate = entryDate;
        this.ipAddress = ipAdrress;
        this.login = login;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getLogin() {
        return login;
    }
}
