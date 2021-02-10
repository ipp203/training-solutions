package week15.d03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostFinder {
    private List<Post> posts;

    public PostFinder(List<week15.d03.Post> posts) {
        this.posts = new ArrayList<>(posts);
    }

    public List<Post> findPosts(String user) {
        List<Post> result = posts.stream()
                .filter(Post::isContentOrTitleNotEmpty)
                .filter(post -> post.isEarlierThanNow() || post.isOwnPost(user))
                .filter(Post::isNotDeleted)
                .collect(Collectors.toList());
        return result;
    }

/*
*- A Post publishedAt dátuma korábbi kell, hogy legyen, mint a LocalDate.now()
*- Ha a Post publishedAt dátuma későbbi, mint a LocalDate.now(), akkor csak azokat a Post-okat adjuk vissza,
 melyek owner-e megegyezik a megadott user-rel.
*- A content és a title nem lehet üres
- A deletedAt értéke null kell, hogy legyen, vagy későbbi, mint a LocalDate.now().

*/
}
