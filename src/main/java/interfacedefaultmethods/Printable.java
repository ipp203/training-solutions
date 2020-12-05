package interfacedefaultmethods;

public interface Printable {
    String BLACK = "#000000";
    String RED = "#FF0000";

    int getLength();

    String getPage(int pageIndex);

    default String getColor(int pageIndex) {
        return BLACK;
    }
}
