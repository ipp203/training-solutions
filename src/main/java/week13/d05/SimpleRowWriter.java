package week13.d05;

import java.util.Optional;

public class SimpleRowWriter implements RowWriter{

    @Override
    public String createLine(BillItem bill) {
        return String.format("%d %s, darabja %d Ft",
                bill.getNumber(),bill.getName(),bill.getUnitPrice());
    }

    @Override
    public Optional<String> getHeader() {
        return Optional.empty();
    }
}
