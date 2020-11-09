package typeconversion.whichtype;

import java.util.List;

public class WhichTypeMain {
    public static void main(String[] args) {
        WhichType whichType = new WhichType();

        String s = "123456789";
        List<Type> typeList = whichType.whichType(s);
        System.out.println(s + " type:" +typeList.toString());

        s = "40000";
        typeList = whichType.whichType(s);
        System.out.println(s + " type:" +typeList.toString());

        s = "4000";
        typeList = whichType.whichType(s);
        System.out.println(s + " type:" +typeList.toString());

        s = "180";
        typeList = whichType.whichType(s);
        System.out.println(s + " type:" +typeList.toString());

        s = "120";
        typeList = whichType.whichType(s);
        System.out.println(s + " type:" +typeList.toString());
    }
}
