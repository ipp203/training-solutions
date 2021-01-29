package week13.d05;

import java.util.Optional;

public class ComplexRowWriter implements RowWriter{

    @Override
    public String createLine(BillItem bill) {
        return String.format("%-19s%13d%6d%7d",
                bill.getName(),bill.getUnitPrice(),bill.getNumber(),bill.getNumber()*bill.getUnitPrice());
    }

    @Override
    public Optional<String> getHeader() {
        return Optional.of("Megnevezés         Egységár (Ft) Darab Összeg");
    }
}
