package dateduration;

import java.time.Duration;
import java.time.Instant;

public class StringCreationStudies {

    public long measureStringCreationTimeRequiredOnHeap(int objectsCount) {
        Instant iStart = Instant.now();

        String[] s = new String[objectsCount];
        for (int i = 0; i < objectsCount; i++) {
            s[i] = new String("a");
        }
        Instant iEnd = Instant.now();
        return Duration.between(iStart, iEnd).toMillis();
    }

    public long measureStringCreationTimeRequiredInPool(int objectsCount) {
        Instant iStart = Instant.now();

        String[] s = new String[objectsCount];
        for (int i = 0; i < objectsCount; i++) {
            s[i] = "a";
        }
        Instant iEnd = Instant.now();
        return Duration.between(iStart, iEnd).toMillis();
    }

    public static void main(String[] args) {
        int objCount = 1_000_000;
        long heap = new StringCreationStudies().measureStringCreationTimeRequiredOnHeap(objCount);
        System.out.println("heap: " + heap + " ms");

        long pool = new StringCreationStudies().measureStringCreationTimeRequiredInPool(objCount);
        System.out.println("pool: " + pool + " ms");
    }
}
