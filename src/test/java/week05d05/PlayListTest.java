package week05d05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayListTest {

    @Test
    void testCreate() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("AAA", 123, "Jhon Doe"));
        songs.add(new Song("BBB", 119, "Jhon Doe"));
        songs.add(new Song("CCC", 153, "Jhon Doe"));
        songs.add(new Song("DDD", 13, "Jhon Doe"));
        PlayList playList = new PlayList(songs);
        System.out.println(playList.findByLengthGreraterThan(2));
    }

}