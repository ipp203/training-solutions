package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private static final double ROUNDER = 100.0;
    private final List<Mark> marks;
    private String name;

    public Student(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
        marks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + " marks: ");
        for (int i = 0; i < marks.size(); i++) {
            if (i > 0) {
                sb.append("\n");
            }
            sb.append(marks.get(i).getSubject().getSubjectName() + ": " + marks.get(i).toString());
        }
        return sb.toString();
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    public double calculateAverage() {
        /* if (isEmpty()) {
            throw new ArithmeticException("List is empty.");
        }*/

        double average = 0.0;
        for (Mark mark : marks) {
            average += mark.getMarkType().getValue();
        }
        average /= marks.size();

        return Math.round(ROUNDER * average) / ROUNDER;
    }

    public double calculateSubjectAverage(Subject subject) {
       /* if (isEmpty()) {
            throw new ArithmeticException("List is empty.");
        }*/
        if (subject == null) {
            throw new NullPointerException("Subject must not be null!");
        }

        double average = 0.0;
        int counter = 0;

        for (Mark mark : marks) {
            if (mark.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                average += mark.getMarkType().getValue();
                counter++;
            }
        }
        if (counter == 0) {
            //throw new ArithmeticException("No mark in this subject.");

        } else {
            average /= counter;
        }

        return Math.round(ROUNDER * average) / ROUNDER;
    }

 /*   private boolean isEmpty() {
        return marks.isEmpty();
    }*/
}
