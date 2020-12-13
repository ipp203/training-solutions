package week04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week04.d02.Search;

import java.util.Arrays;

public class SearchTest {
    private Search target;

    @BeforeEach
    public void setUp() {
        target = new Search();
    }

    @Test
    public void Given_a_string_and_a_char_When_there_is_one_match_Then_the_proper_index_is_returned() {
        Assertions.assertEquals(
                Arrays.asList(1),
                target.getIndexesOfChar("ketchup", 'e')
        );
    }

    @Test
    public void Given_a_string_and_a_char_When_there_is_more_than_one_match_Then_the_proper_indexes_are_returned() {
        Assertions.assertEquals(
                Arrays.asList(1, 3),
                target.getIndexesOfChar("kefe", 'e')
        );
    }
}
