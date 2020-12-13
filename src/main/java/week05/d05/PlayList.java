package week05.d05;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Song song : songs) {
            sb.append(song);
            sb.append("\n");
        }
        return sb.toString();
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
