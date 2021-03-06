package week13.d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {
    Quiz quiz;

    @BeforeEach
    void init() {
        quiz = new Quiz();
        quiz.loadFromFile(new BufferedReader(
                new InputStreamReader(
                        Quiz.class.getResourceAsStream("results.txt"))));
    }

    @Test
    void isGoodAnswer() {
        assertTrue(quiz.isGoodAnswer("AB123", 0));
    }

    @Test
    void mostSkippedCode() {
        assertEquals("BD452", quiz.mostSkippedCode());
    }

    @Test
    void getWinner() {
        assertEquals("GH1234", quiz.getWinner());
    }
}