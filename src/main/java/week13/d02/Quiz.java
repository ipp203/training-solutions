package week13.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {
    private char[] goodAnswers;
    private Map<String, List<Character>> resultMap = new HashMap<>();

    public void loadFromFile(BufferedReader reader) {
        try (reader) {
            readLines(reader);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }

    public boolean isGoodAnswer(String code, int index) {
        Character answer = resultMap.get(code).get(index);
        return answer.equals(goodAnswers[index]);
    }

    public String mostSkippedCode() {
        String code = "";
        int max = 0;
        for (Map.Entry<String, List<Character>> entrie : resultMap.entrySet()) {
            int counter = getXCounter(entrie);
            if (max < counter) {
                code = entrie.getKey();
                max = counter;
            }
        }
        return code;
    }

    public String getWinner() {
        String code = "";
        int max = 0;
        for (Map.Entry<String, List<Character>> entry : resultMap.entrySet()) {

            int points = getPoints(entry);
            if (max < points) {
                code = entry.getKey();
                max = points;
            }

        }
        return code;
    }

    private void readLines(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        goodAnswers = line.toCharArray();
        while ((line = reader.readLine()) != null) {
            processLine(line);
        }
    }

    private void processLine(String line) {
        String[] data = line.split(" ");
        String code = data[0];
        char answer = data[1].charAt(0);
        if (!resultMap.containsKey(code)) {
            resultMap.put(code, new ArrayList<>());
        }
        resultMap.get(code).add(answer);
    }

    private int getXCounter(Map.Entry<String, List<Character>> entry) {
        int counter = 0;
        for (Character c : entry.getValue()) {
            if (c == 'X') {
                counter++;
            }
        }
        return counter;
    }

    private int getPoints(Map.Entry<String, List<Character>> entry) {
        int counter = 0;
        List<Character> list = entry.getValue();

        for (int i = 0; i < list.size(); i++) {
            if (isGoodAnswer(entry.getKey(), i)) {
                counter += i + 1;
            } else {
                if (list.get(i) != 'X') {
                    counter -= 2;
                }
            }
        }
        return counter;
    }


    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.loadFromFile(new BufferedReader(new InputStreamReader(Quiz.class.getResourceAsStream("results.txt"))));

        System.out.println(quiz.isGoodAnswer("AB123", 0));
        System.out.println(quiz.mostSkippedCode());
        System.out.println(quiz.getWinner());
    }
}
