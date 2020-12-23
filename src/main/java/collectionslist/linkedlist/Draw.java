package collectionslist.linkedlist;

import java.util.*;

public class Draw {

    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber) {
            throw new IllegalArgumentException("drawCount must be less then " + maxNumber + "!");
        }

        List<Integer> numbers = createNumbers(maxNumber);

        Set<Integer> result = new TreeSet<>();
        for (int i = 0; i < drawCount; i++) {
            result.add((Integer) ((Queue) numbers).poll());
        }

        return result;
    }

    private List<Integer> createNumbers(int maxNumber) {
        List<Integer> balls = new LinkedList<>();
        for (int i = 0; i < maxNumber; i++) {
            balls.add(i);
        }
        Collections.shuffle(balls);
        return balls;
    }
}
