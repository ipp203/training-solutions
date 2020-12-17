package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {
    private String title;
    private int length;
    private List<String> performers;
    private List<String> composer;

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("Empty performers");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Length is less or equal 0");
        }

        this.title = title;
        this.length = length;
        this.performers = performers;
        this.composer = composer;
    }

    public AudioFeatures(String title, int length, List<String> performers) {
        this(title, length, performers, null);
    }

    @Override
    public List<String> getContributors() {
        List<String> result = new ArrayList<>(performers);
        if (!Validators.isEmpty(composer)) {
            result.addAll(0, composer);
        }
        return result;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
}
