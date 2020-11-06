package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private List<Member> connection;

    public Member(String name) {
        this.name = name;
        connection = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Member> getConnection() {
        return connection;
    }

    public void connectMember(Member member) {
        if (member != null) {
            connection.add(member);
        }
    }

    private List<String> connectedNames() {
        List<String> connectedNames = new ArrayList<>();
        for (Member member : connection) {
            connectedNames.add(member.getName());
        }
        return connectedNames;
    }

    @Override
    public String toString() {
        return name + ": " + connectedNames();
    }

    /*@Override
    public String toString() {
        return name + " " + connections.toString();
    }*/
}
