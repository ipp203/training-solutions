package catalog;

public class SearchCriteria {
    public String contributor;
    public String title;

    private SearchCriteria(String contributor, String title) {
        this.contributor = contributor;
        this.title = title;
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }

    public static SearchCriteria createByTitle(String title) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Title is empty");
        }
        return new SearchCriteria(null, title);
    }

    public static SearchCriteria createByContributor(String contributor) {
        if (Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("Contributor is empty");
        }
        return new SearchCriteria(contributor, null);
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Title is empty");
        }
        if (Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("Contributor is empty");
        }
        return new SearchCriteria(contributor, title);
    }

    public boolean hasContributor() {
        return !Validators.isBlank(contributor);
    }

    public boolean hasTitle() {
        return !Validators.isBlank(title);
    }

}
