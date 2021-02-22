package week15.d03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostFinderTest {

    @Test
    void testFindPosts() {
        List<Post> testData = Arrays.asList(
                new Post("My First Post", LocalDate.of(2018, 1, 6), LocalDate.of(2019, 6, 19), "Tartalom", "Pista"),
                new Post("My Article", LocalDate.of(2019, 3, 18), null, "Tartalom", "Pista"),
                new Post("I like Java", LocalDate.of(2020, 2, 20), null, "Tartalom", "Pista"),
                new Post("I don't like Java", LocalDate.of(2021, 2, 20), null, "Tartalom", "Jani")
        );

        PostFinder postFinder = new PostFinder(testData);
        List<Post> result = postFinder.findPosts("Pista");
        assertEquals(3, result.size());
    }

    @Test
    void testFindPostWithNull(){
        Exception ex = assertThrows(IllegalArgumentException.class,()->new PostFinder(null));
        assertEquals("Argument can not be null!",ex.getMessage());
    }
    @Test
    void testFindPostWithEmptyList(){
        PostFinder postFinder = new PostFinder(Arrays.asList());
        List<Post> result = postFinder.findPosts("Pista");
        assertEquals(0,result.size());
    }
}