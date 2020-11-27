package week05d05;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    List<Song> songs;

    public PlayList(List<Song> songs) {
        if (songs == null) {
            throw new IllegalArgumentException("Songs is null.");
        }
        this.songs = songs;
    }

    public List<Song> findByLengthGreraterThan(int mins) {
        List<Song> longSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getLengthInSeconds() / 60 >= mins) {
                longSongs.add(song);
            }
        }
        return longSongs;
    }
}
