package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {
    private static final double ROUNDER = 100.0;
    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public String getClassName() {
        return className;
    }

    public boolean isEmpty() {
        return students.isEmpty();
    }

    public boolean addStudent(Student student) {
        if (student == null) {
            throw new NullPointerException("");
        }
        for (Student st : students) {
            if (st.getName().equals(student.getName())) {
                return false;
            }
        }
        return students.add(student);
    }

    public boolean removeStudent(Student student) {
        if (student == null) {
            throw new NullPointerException("");
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(student.getName())) {
                students.remove(i);
                return true;
            }
        }

        return false;
    }

    public Student findStudentByName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if (isEmpty()) {
            throw new IllegalStateException("No students to search!");
        }
        for (Student student : students) {
            if (student.getName().equals(name.trim())) {
                return student;
            }
        }
        throw new IllegalArgumentException(String.format("Student by this name cannot be found! %s", name));
    }

    public String listStudentNames() {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < students.size(); i++) {
            sb.append(students.get(i).getName());
            if (i < students.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> studyResults = new ArrayList<>();
        for (Student student : students) {
            studyResults.add(new StudyResultByName(student.getName(), student.calculateAverage()));
        }
        return studyResults;
    }

    public Student repetition() {
        if (isEmpty()) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(rnd.nextInt(students.size()));
    }

    public double calculateClassAverage() {
        if (isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }

        double average = 0.0, d = 0.0;
        for (Student student : students) {

            d = student.calculateAverage();
            if (d < 1e-8) {
                throw new ArithmeticException("No marks present, average calculation aborted!");
            }
            average += d;
        }
        average /= students.size();
        return Math.round(ROUNDER * average) / ROUNDER;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        if (subject == null) {
            throw new NullPointerException("Subject must not be null!");
        }
        if (isEmpty()) {
            throw new ArithmeticException("List is empty.");
        }

        double average = 0.0, d;
        int counter = 0;
        for (Student student : students) {
            try {
                d = student.calculateSubjectAverage(subject);
                if (d > 1e-8) {
                    average += d;
                    counter++;
                }
            } catch (ArithmeticException ae) {
                //throw new ArithmeticException("No marks present, average calculation aborted!");
            }
        }

        if (counter == 0) {
            throw new ArithmeticException("No mark in this subject.");
        } else {
            average /= counter;
        }

        return Math.round(ROUNDER * average) / ROUNDER;
    }


}
