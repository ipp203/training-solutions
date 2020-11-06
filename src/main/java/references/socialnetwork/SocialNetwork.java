package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<Member> members = new ArrayList<>();

    public void addMember(String name) {
        members.add(new Member(name));
    }

    private Member findByName(String name){
        for (Member m:members) {
            if (m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }

    public void connect(String name, String otherName) {
        Member m = findByName(name);
        if (m != null){
            m.connectMember(findByName(otherName));
        }
    }

    public List<String> bidirectionalConnections(){
        List<String> listOfbidiConnection = new ArrayList<>();
        for (Member m: members) {
            for (Member cm: m.getConnection() ) {
                if (cm.getConnection().contains(m)){
                    listOfbidiConnection.add(m.getName() + " - " + cm.getName());
                }
            }
        }
        return listOfbidiConnection;
    }

    @Override
    public String toString(){
        return members.toString();
    }

}
