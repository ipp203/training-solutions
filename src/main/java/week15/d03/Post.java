package week15.d03;

import java.time.LocalDate;

public class Post {
    private String title;
    private LocalDate publishedAt;
    private LocalDate deletedAt;
    private String content;
    private String owner;

    public Post(String title, LocalDate publishedAt, LocalDate deletedAt, String content, String owner) {
        this.title = title;
        this.publishedAt = publishedAt;
        this.deletedAt = deletedAt;
        this.content = content;
        this.owner = owner;
    }

    public boolean isContentOrTitleNotEmpty() {
        return !(content.isBlank() || title.isBlank());
    }

    public boolean isOwnPost(String user) {
        return this.owner.equals(user);
    }

    public boolean isEarlierThanNow() {
        return publishedAt.isBefore(LocalDate.now());
    }

    public boolean isNotDeleted() {
        return deletedAt == null || deletedAt.isAfter(LocalDate.now());
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", publishedAt=" + publishedAt +
                ", deletedAt=" + deletedAt +
                ", content='" + content + '\'' +
                ", owner='" + owner;
    }
}
