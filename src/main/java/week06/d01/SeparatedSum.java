package week06.d01;

import java.util.Scanner;

public class SeparatedSum {
    public PosNegSum sum(String values) {
        if (values == null || values.isBlank()) {
            throw new IllegalArgumentException("Values must not be empty!");
        }

        PosNegSum result = new PosNegSum(0, 0);

        try (Scanner scanner = new Scanner(values).useDelimiter(";")) {
            while (scanner.hasNext()) {
                String s = scanner.next();
                s = s.replace(',', '.');
                double d = Double.parseDouble(s);
                if (d > 0) {
                    result.addPos(d);
                } else {
                    result.addNeg(d);
                }
            }
        }
        return result;
    }
}
