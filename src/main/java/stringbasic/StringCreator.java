package stringbasic;

public class StringCreator {
    public String createStringForPool() {
        return "alma";
    }

    public String createStringForHeap() {
        return new String("alma");
    }
}
