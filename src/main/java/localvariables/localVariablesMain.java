package localvariables;

public class localVariablesMain {
    public static void main(String[] args) {
        boolean b = false;
        int a = 2;
        int i = 3, j = 4;
        int k = i;
        String s = "Hello World!";
        String t = s;

        {
            int x = 0;
            System.out.println(x);
        }
        //System.out.println(x);

    }
}
