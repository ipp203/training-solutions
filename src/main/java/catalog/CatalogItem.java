package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {
    private String registrationNumber;
    private int price;
    private List<Feature> features;

    public CatalogItem(String registrationNumber, int price, Feature... features) {
        if (Validators.isBlank(registrationNumber)) {
            throw new IllegalArgumentException("Empty registration number!");
        }
        if (features == null) {
            throw new IllegalArgumentException("Empty features!");
        }

        this.registrationNumber = registrationNumber;
        this.price = price;
        this.features = Arrays.asList(features);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getPrice() {
        return price;
    }

    public List<Feature> getFeatures() {
        return new ArrayList<>(features);
    }

    public int fullLengthAtOneItem() {
        int sumLength = 0;
        for (Feature item : features) {
            if (item instanceof AudioFeatures) {
                sumLength += ((AudioFeatures) item).getLength();
            }
        }
        return sumLength;
    }

    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();

        for (Feature item : features) {
            contributors.addAll(item.getContributors());
        }
        return contributors;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();

        for (Feature item : features) {
            titles.add(item.getTitle());
        }
        return titles;
    }

    public boolean hasAudioFeature() {
        for (Feature item : features) {
            if (item instanceof AudioFeatures) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPrintedFeature() {
        for (Feature item : features) {
            if (item instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }

    public int numberOfPagesAtOneItem() {
        int result = 0;
        for (Feature item : features) {
            if (item instanceof PrintedFeatures) {
                result += ((PrintedFeatures) item).getNumberOfPages();
            }
        }
        return result;
    }
}
