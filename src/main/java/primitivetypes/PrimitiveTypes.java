package primitivetypes;

public class PrimitiveTypes {
    final static int BITLENGTH = 32;
/*    public String toBinaryString(int n) {
        return Integer.toString(n, 2);
    }*/

/*    public String toBinaryString(int n) {


        String nString = Integer.toString(n, 2);
        int nStringLength = nString.length();

        for (int i = nStringLength; i < BITLENGTH; i++) {
            nString = '0' + nString;
        }
        return nString;
    }*/

    public String toBinaryString(int n) {
        String nString = "";
        for (int i = Math.abs(n); i > 0; ) {
            nString = Integer.toString(i % 2) + nString;
            i = i / 2;
        }

        int nStringLength = nString.length();
        for (int i = nStringLength; i < BITLENGTH; i++) {
            nString = '0' + nString;
        }
        return nString;
    }
}
