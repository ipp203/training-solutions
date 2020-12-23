package collectionslist.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }

        List<Integer> balls = createBalls(ballCount);

        List<Integer> result = balls.subList(0, lotteryType);
        Collections.sort(result);

        return result;
    }

    private List<Integer> createBalls(int ballCount) {
        List<Integer> balls = new ArrayList<>(ballCount);
        for (int i = 1; i <= ballCount; i++) {
            balls.add(i);
        }
        Collections.shuffle(balls);
        return balls;
    }

}
