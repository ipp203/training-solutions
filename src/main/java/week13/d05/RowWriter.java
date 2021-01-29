package week13.d05;

import java.util.Optional;

public interface RowWriter {
   String createLine(BillItem bill);
   Optional<String> getHeader();
}
