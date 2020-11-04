package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Capsules {
    private List<String> colorOfCapsules = new ArrayList<>();

    public void addLast(String item) {
        colorOfCapsules.add(item);
    }

    public void addFirst(String item) {
        colorOfCapsules.add(0, item);
    }

    public void removeFirst() {
        colorOfCapsules.remove(0);
    }

    public void removeLast() {
        colorOfCapsules.remove(colorOfCapsules.size() - 1);
    }

    public List<String> getColors() {
        return colorOfCapsules;
    }

    public static void main(String[] args) {
        Capsules capsules = new Capsules();

        capsules.addFirst("red");
        capsules.addLast("blue");
        capsules.addFirst("white");
        capsules.addLast("green");

        System.out.println(capsules.getColors());
        System.out.println(capsules.getColors().toString());

        capsules.removeFirst();
        capsules.removeLast();

        System.out.println(capsules.getColors());

        List<String> colorsOfCapsules = capsules.getColors();
        colorsOfCapsules.clear();
        System.out.println(capsules.getColors());


    }
}
