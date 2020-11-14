package stringbuilder;

public class NameBuilder {

    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        StringBuilder sb = new StringBuilder(givenName);
        if (!isEmpty(middleName)) {
            sb.append(" " + middleName);
        }
        sb.append(" " + familyName);

        if (title != null) {
            sb.insert(0, title.title + " ");
        }
        return sb.toString();
    }

    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }

        StringBuilder sb = new StringBuilder(familyName);
        if (!isEmpty(middleName)) {
            sb.append(" " + middleName);
        }
        sb.append(" " + givenName);
        if (title != null) {
            sb.insert(0, title.title + " ");
        }
        return sb.toString();
    }

    public String insertTitle(String name, Title title, String where) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Name must not be empty!");
        }
        if (title == null) {
            return name;
        }

        StringBuilder sb = new StringBuilder(name);
        int index = sb.indexOf(where);
        if (index == -1) {
            return name;
        }
        sb.insert(index, " " + title.title);

        return sb.toString();
    }

    public String deleteNamePart(String name, String delete) {
        StringBuilder sb = new StringBuilder(name);
        int index = sb.indexOf(delete);
        sb.delete(index, index + delete.length());
        return sb.toString();
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}
