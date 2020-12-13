package week05.d05;

public class Song {
    private String name;
    private long lengthInSeconds;
    private String artist;

    public Song(String name, long lengthInSeconds, String artist) {
        if (isEmpty(name) || isEmpty(artist)) {
            throw new IllegalArgumentException("Name and artist can not be empty!");
        }
        if (lengthInSeconds <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0!");
        }
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    @Override
    public String toString() {
        return artist + ": " + name + " (" + lengthInSeconds + ")";
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}
