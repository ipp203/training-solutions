package ioreader.grades;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String Name;
    private List<Integer> gradeList;

    public Student(String name, List<Integer> gradeList) {
        Name = name;
        this.gradeList = gradeList;
    }

    public String getName() {
        return Name;
    }

    public List<Integer> getGradeList() {
        return new ArrayList<>(gradeList);
    }

    public double average() {
        double result = 0.0;
        for (int grade : gradeList) {
            result += grade;
        }
        return result / gradeList.size();
    }

    public boolean isIncreasing() {
        for (int i = 0; i < gradeList.size() - 1; i++) {
            if (gradeList.get(i + 1) < gradeList.get(i)) {
                return false;
            }
        }
        return true;
    }
}
