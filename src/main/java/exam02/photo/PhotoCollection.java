package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {
    private List<Photo> photos = new ArrayList<>();

    public List<Photo> getPhotos() {
        return List.copyOf(photos);
    }

    public void addPhoto(String... namesOfPhoto) {
        if (namesOfPhoto == null){
            throw new IllegalArgumentException("NamesOfPhoto is null!");
        }
        for (String name : namesOfPhoto) {
            this.photos.add(new Photo(name));
        }
    }

    public void starPhoto(String name, Quality quality) {
        if (quality == null){
            throw new IllegalArgumentException("Quality is null!");
        }
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name is null or empty!");
        }

        for (Photo photo : photos) {
            if (photo.getName().equals(name)) {
                photo.setQuality(quality);
                return;
            }
        }
        throw new PhotoNotFoundException("Photo not found");
    }

    public int numberOfStars() {
        int sumOfStars = 0;
        for (Photo photo : photos) {
            sumOfStars += photo.getQuality().getStarNumber();
        }
        return sumOfStars;
    }
}
