package week08.d05;


import java.io.IOException;
import java.io.InputStreamReader;

/*Egy repülőgéppel átszeljük az óceánt és a közben méréseket végzünk.
Tudjuk, hogy partól indulunk és parthoz érünk.
A méréseket adott időközönként egyenletesen végezzük.
A mérések azt mutatják, hogy sziget vagy óceán fölött repülünk éppen.
Az 1-es szigetet míg a 0 óceánt jelöl.
pl.: 111000010100001  sorozatban egy három "hosszú" sziget majd négy hosszú "óceán",
aztán sziget, víz, sziget, majd óceán és végül egy szigeten leszálltunk.
A map.txt állományban egy "térképet" tárolunk.
A feladat az, hogy "repüljünk" a térkép fölött végig és határozzuk meg a leghosszabb óceán szakasz hosszát.
A térkép fölött csak egyszer repülhetünk el és amikor leszálltunk már tudnunk is kell az eredményt.
(Magyarul ne olvasd be a file-t a memóriába) A feladatot a week08d05.Plane osztályba végezzük el.
A térkép: 10000000111110000000000001111111111000010000010000100000111111110000101000000000111110000000000000000100000001000000000000111111000000000100000000000011*/

public class Plane {

    private static final char OCEAN = '0';
    private static final char EARTH = '1';

    public int getLongestFlightOverOcean() {
        int result = 0;

        try (InputStreamReader isr = new InputStreamReader(Plane.class.getResourceAsStream("map.txt"))) {
            int lengthOfOcean = 0;
            char[] c = new char[1];

            while (isr.read(c) >= 0) {
                if (c[0] == OCEAN) {
                    lengthOfOcean++;
                }
                if (c[0] == EARTH) {
                    if (lengthOfOcean > result) {
                        result = lengthOfOcean;
                    }
                    lengthOfOcean = 0;
                }
            }

/*            int lengthOfOcean = 0;
            int i;
            while ((i = isr.read()) >= 0) {
                if ((char) i == OCEAN) {
                    lengthOfOcean++;
                }
                if ((char) i == EARTH) {
                    if (lengthOfOcean > result) {
                        result = lengthOfOcean;
                    }
                    lengthOfOcean = 0;
                }
            }
*/
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return result;
    }

    public static void main(String[] args) {
        Plane plane = new Plane();
        System.out.println(plane.getLongestFlightOverOcean());
    }
}
