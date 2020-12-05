package interfacedefaultmethods;

public class Printer {
    public String print(Printable printable) {
        StringBuilder pages = new StringBuilder();
        for (int i = 0; i < printable.getLength(); i++) {
            if (!printable.getColor(i).equals(Printable.BLACK)) {
                pages.append("[");
                pages.append(printable.getColor(i));
                pages.append("]");
            }
            pages.append(printable.getPage(i));
            pages.append("\n");

        }
        return pages.toString();
    }
}
