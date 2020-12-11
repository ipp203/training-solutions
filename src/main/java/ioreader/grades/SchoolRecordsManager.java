package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {
    List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void readGradesFromFile(String pathString) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(pathString))) {
            String line;
            while ((line = reader.readLine()) != null) {
                students.add(loadStudentData(line));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("", ioe);
        }
    }

    private Student loadStudentData(String line) {
        String[] data = line.split(" ");
        List<Integer> marks = new ArrayList<>();
        for (int i = 1; i < data.length; i++) {
            marks.add(Integer.parseInt(data[i]));
        }
        return new Student(data[0], marks);
    }

    public double classAverage() {
        double average = 0.0;
        for (Student student : students) {
            average += student.average();
        }
        return average / students.size();
    }
}
