package lambdaintro;

import java.util.ArrayList;
import java.util.List;

public class Member {

    public enum Sex {MALE, FEMALE}

    private String name;
    private List<String> skills;
    private Sex gender;
    private List<String> messages;

    public Member(String name, List<String> skills, Sex gender) {
        this.name = name;
        this.skills = skills;
        this.gender = gender;
        this.messages = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public Sex getGender() {
        return gender;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void sendMessage(String message){
        messages.add(message);
    }

}
