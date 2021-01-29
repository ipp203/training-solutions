package week13.d05;

import java.util.List;

public class BillWriter {

    public String writeBills(List<BillItem> bills, RowWriter rw){
        StringBuilder result;
        if (rw.getHeader().isPresent()) {
            result = new StringBuilder(rw.getHeader().get()+"\n");
        }else{
            result = new StringBuilder("");
        }
        for (BillItem bill:bills) {
            result.append(rw.createLine(bill));
            result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        BillWriter bw = new BillWriter();
        String s = bw.writeBills(List.of(new BillItem("tej",5,100),
                new BillItem("kenyer",3,150)),new SimpleRowWriter());
        System.out.println(s);
        System.out.println("-------------------");
        s = bw.writeBills(List.of(new BillItem("tej",5,100),
                new BillItem("kenyer",3,150)),new ComplexRowWriter());
        System.out.println(s);

    }
}
