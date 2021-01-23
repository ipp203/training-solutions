package week12.d05;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int age;
    private int skillLevel;
    private String name;
    private List<String> skills;

    public Employee(int age, int skillLevel, String name, List<String> skills) {
        if (skills == null){
            throw new IllegalArgumentException("Skills list is null");
        }
        this.age = age;
        this.skillLevel = skillLevel;
        this.name = name;
        this.skills = new ArrayList<>(skills);
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }
}
