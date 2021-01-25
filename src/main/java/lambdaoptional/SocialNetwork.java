package lambdaoptional;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class SocialNetwork {
    private List<Member> members;

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }

    public Optional<Member> findFirst(Predicate<Member> condition) {
        for (Member member : members) {
            if (condition.test(member)) {
                return Optional.of(member);
            }
        }
        return Optional.empty();
    }

    public Optional<Double> averageNumberOfSkills() {
        if (members.size() == 0) {
            return Optional.empty();
        }
        double sum = 0;
        for (Member member : members) {
            sum += member.getSkills().size();
        }
        return Optional.of(sum / members.size());
    }
}
