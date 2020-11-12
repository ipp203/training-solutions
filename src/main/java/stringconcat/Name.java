package stringconcat;

public class Name {
    private String familyName, middleName, givenName;
    private Title title;

    private static final String EXCEPTIONMESSAGE = "Family name and given name must not be empty!";

    private boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public Name(String familyName, String middleName, String givenName, Title title) {
        if (!isEmpty(familyName)) {
            this.familyName = familyName;
        } else {
            throw new IllegalArgumentException(EXCEPTIONMESSAGE);
        }
        if (!isEmpty(givenName)) {
            this.givenName = givenName;
        } else {
            throw new IllegalArgumentException(EXCEPTIONMESSAGE);
        }
        if (middleName != null) {
            this.middleName = middleName;
        } else {
            this.middleName = "";
        }
        this.title = title;
    }

    public Name(String familyName, String middleName, String givenName) {
        if (!isEmpty(familyName)) {
            this.familyName = familyName;
        } else {
            throw new IllegalArgumentException(EXCEPTIONMESSAGE);
        }
        if (!isEmpty(givenName)) {
            this.givenName = givenName;
        } else {
            throw new IllegalArgumentException(EXCEPTIONMESSAGE);
        }
        if (middleName != null) {
            this.middleName = middleName;
        } else {
            this.middleName = "";
        }
    }

    public String concatNameWesternStyle() {
        String name = "";
        if (title != null) {
            name += title.getTitleString() + " ";
        }

        name += givenName + " ";

        if (middleName.length() > 0) {
            name = name.concat(middleName) + " ";
        }

        return name + familyName;
    }

    public String concatNameHungarianStyle() {
        String name = "";
        if (title != null) {
            name += title.getTitleString() + " ";
        }
        name += familyName + " ";

        if (middleName.length() > 0) {
            name = name.concat(middleName) + " ";
        }
        return name + givenName;
    }
}
