package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }

        double result = 0.0;
        int number = 0;
        for (CatalogItem item : catalogItems) {
            if (item.numberOfPagesAtOneItem() > limit) {
                result += item.numberOfPagesAtOneItem();
                number++;
            }
        }

        if (number == 0) {
            throw new IllegalArgumentException("No page");
        }
        return result / number;
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        CatalogItem removeItem = null;
        for (CatalogItem item : catalogItems) {
            if (item.getRegistrationNumber().equals(registrationNumber)) {
                removeItem = item;
            }
        }
        if (removeItem != null) {
            catalogItems.remove(removeItem);
        }
    }

    public int getAllPageNumber() {
        int sumPage = 0;
        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature()) {
                sumPage += item.numberOfPagesAtOneItem();
            }
        }
        return sumPage;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> items = new ArrayList<>();

        for (CatalogItem item : catalogItems) {
            if (item.hasAudioFeature()) {
                items.add(item);
            }
        }
        return items;
    }

    public int getFullLength() {
        int fullLength = 0;
        for (CatalogItem item : catalogItems) {
            if (item.hasAudioFeature()) {
                fullLength += item.fullLengthAtOneItem();
            }
        }
        return fullLength;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> items = new ArrayList<>();

        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature()) {
                items.add(item);
            }
        }
        return items;
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> items = null;
        if (searchCriteria.hasContributor() && searchCriteria.hasTitle()) {
            items = getListByContributor(catalogItems, searchCriteria.getContributor());
            items = getListByTitle(items, searchCriteria.getTitle());

        } else if (searchCriteria.hasContributor()) {
            items = getListByContributor(catalogItems, searchCriteria.getContributor());

        } else if (searchCriteria.hasTitle()) {
            items = getListByTitle(catalogItems, searchCriteria.getTitle());

        }
        if (items == null) {
            throw new IllegalArgumentException("No item found");
        }
        return items;
    }

    private List<CatalogItem> getListByContributor(List<CatalogItem> searchList, String contributor) {
        List<CatalogItem> items = new ArrayList<>();
        for (CatalogItem item : searchList) {
            if (hasContributor(contributor, item)) {
                items.add(item);
            }
        }
        return items;
    }

    private List<CatalogItem> getListByTitle(List<CatalogItem> searchList, String title) {
        List<CatalogItem> items = new ArrayList<>();
        for (CatalogItem item : searchList) {
            if (hasTitle(title, item)) {
                items.add(item);
            }
        }
        return items;
    }

    private boolean hasContributor(String contributor, CatalogItem item) {
        for (String str : item.getContributors()) {
            if (str.equals(contributor)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasTitle(String title, CatalogItem item) {
        for (String str : item.getTitles()) {
            if (str.equals(title)) {
                return true;
            }
        }
        return false;
    }

}
