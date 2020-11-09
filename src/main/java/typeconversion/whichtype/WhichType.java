package typeconversion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {
    public List<Type> whichType(String s){
        List<Type> typeList = new ArrayList<>();
        long l = Long.parseLong(s);
        if (l>=Long.MIN_VALUE && l<=Long.MAX_VALUE){
            for (Type t:Type.values()) {
                if (t.getMinValue()<=l && l<=t.getMaxValue()){
                    typeList.add(t);
                }
            }
        }
        return typeList;
    }
}
