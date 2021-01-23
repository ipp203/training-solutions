package week12.d04;

import java.io.IOException;
import java.io.InputStream;

public class Secret {
    public void decode() {
        try (InputStream is = Secret.class.getResourceAsStream("secret.dat")) {
            Integer i;
            StringBuilder s = new StringBuilder("");
            while ((i = is.read()) > -1) {
                s.append((char) (i + 10));
            }
            System.out.println(s);
        } catch (IOException ioe) {
            throw new IllegalStateException("");
        }
    }

    public static void main(String[] args) {
        Secret secret = new Secret();
        secret.decode();
    }
}
