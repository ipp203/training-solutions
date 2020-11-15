package schoolrecords;

import java.util.List;

public class Tutor {
    private String name;
    private List<Subject> taughtSubject;

    public Tutor(String name, List<Subject> taughtSubject) {
        this.name = name;
        this.taughtSubject = taughtSubject;
    }

    public String getName() {
        return name;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        for (Subject sb : taughtSubject) {
            if (sb.getSubjectName().equals(subject.getSubjectName())) {
                return true;
            }
        }
        return false;
    }
}
