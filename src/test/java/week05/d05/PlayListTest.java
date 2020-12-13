package week05.d05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PlayListTest {

    @Test
    void testCreate() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("AAA", 123, "John Doe"));
        songs.add(new Song("BBB", 119, "John Doe"));
        songs.add(new Song("CCC", 153, "John Doe"));
        songs.add(new Song("DDD", 13, "John Doe"));
        PlayList playList = new PlayList(songs);

        System.out.println(playList);
        System.out.println(playList.findByLengthGreraterThan(2));

        List<Song> expectedSongs = new ArrayList<>();
        expectedSongs.add(new Song("AAA", 123, "John Doe"));
        expectedSongs.add(new Song("CCC", 153, "John Doe"));
        
    }

}