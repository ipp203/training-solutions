package exam02.photo;

public class Photo implements Qualified {
    private String name;
    private Quality quality;

    public Photo(String name) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name is null or empty!");
        }

        this.name = name;
        this.quality = Quality.NO_STAR;
    }

    public Photo(String name, Quality quality) {
        if (quality == null){
            throw new IllegalArgumentException("Quality is null!");
        }
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name is null or empty!");
        }

        this.name = name;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    @Override
    public Quality getQuality() {
        return quality;
    }

    @Override
    public void setQuality(Quality quality) {
        this.quality = quality;
    }
}
