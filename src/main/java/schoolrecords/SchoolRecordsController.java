package schoolrecords;

import java.util.*;

public class SchoolRecordsController {
    private ClassRecords classRecords;
    private Subject[] subjects = {new Subject("földrajz"),
            new Subject("biológia"),
            new Subject("matematika"),
            new Subject("fizika"),
            new Subject("ének"),
            new Subject("kémia")};

    private Tutor[] tutors;


    public void initSchool() {

        tutors = new Tutor[3];
        tutors[0] = new Tutor("Nagy Csilla", Arrays.asList(subjects[0], subjects[1]));
        tutors[1] = new Tutor("Kiss Csilla", Arrays.asList(subjects[2], subjects[3]));
        tutors[2] = new Tutor("Közepes Csilla", Arrays.asList(subjects[4], subjects[5]));

        Student[] students = new Student[5];
        students[0] = new Student("Jane Doe");
        students[1] = new Student("John Doe");
        students[2] = new Student("Jack Doe");
        students[3] = new Student("Johann Doe");
        students[4] = new Student("Jill Doe");

        Random rnd = new Random(2);

        classRecords = new ClassRecords("2/c", new Random());
        for (Student student : students) {
            for (int j = 0; j < 4; j++) {
                student.grading(new Mark(MarkType.values()[rnd.nextInt(5)],
                        subjects[rnd.nextInt(6)], tutors[rnd.nextInt(3)]));
            }
            classRecords.addStudent(student);
        }
    }

    public void printMenu() {

        System.out.println("\nKérem válasszon az alábbi pontok közül:\n" +
                "1. Diákok nevének listázása\n" +
                "2. Diák név alapján keresése\n" +
                "3. Diák létrehozása\n" +
                "4. Diák név alapján törlése\n" +
                "5. Diák feleltetése\n" +
                "6. Osztályátlag kiszámolása\n" +
                "7. Tantárgyi átlag kiszámolása\n" +
                "8. Diákok átlagának megjelenítése\n" +
                "9. Diák átlagának kiírása\n" +
                "10. Diák tantárgyhoz tartozó átlagának kiírása\n" +
                "11. Kilépés");

    }

    private MarkType inputMarkType() {
        int m;
        Scanner scn = new Scanner(System.in);

        while (true) {
            try {
                m = scn.nextInt();
            } catch (InputMismatchException ime) {
                scn.nextLine();
                System.out.println("Számot adjon meg 1 - 5 között! Kérem újra:");
                continue;
            }
            scn.nextLine();

            if (m >= 1 && m <= 5) {
                return MarkType.values()[MarkType.values().length - m + 1];
            } else {
                System.out.println("Nem jó értéket adott meg, kérem újra:");
            }
        }
    }

    private Subject inputSubject() {
        String name;
        Scanner scn = new Scanner(System.in);

        System.out.println("Kérem a tárgy nevét: ");
        while (true) {
            name = scn.nextLine();
            for (Subject subject : subjects) {
                if (subject.getSubjectName().equals(name.trim())) {
                    return subject;
                }
            }
            System.out.println("Nincs ilyen tantárgy, kérem újra:");
        }
    }

    private Tutor inputTutor() {
        String name;
        Scanner scn = new Scanner(System.in);

        System.out.println("Kérem a tanár nevét: ");
        while (true) {
            name = scn.nextLine();
            for (Tutor tutor : tutors) {
                if (tutor.getName().equals(name.trim())) {
                    return tutor;
                }
            }
            System.out.println("Nincs ilyen tanár, kérem újra:");
        }
    }

    private Student inputStudent() {
        String name;
        Scanner scn = new Scanner(System.in);
        Student student;

        System.out.println("Kérem, adja meg a diák nevét!");
        while (true) {
            name = scn.nextLine();
            try {
                student = classRecords.findStudentByName(name);
            } catch (IllegalArgumentException iae) {
                System.out.println("Nincs ilyen diák. Kérem, adja meg a diák nevét!");
                continue;
            }
            return student;
        }
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        SchoolRecordsController src = new SchoolRecordsController();
        src.initSchool();
        String name;
        Student student;
        Subject subject;
        double d;

        System.out.println("Osztály nyilvántartó");

        int i;
        do {
            src.printMenu();

            try {
                i = scn.nextInt();
            } catch (InputMismatchException ime) {
                i = 0;
            }
            scn.nextLine();

            switch (i) {
                case 1:
                    System.out.println(src.classRecords.getClassName() + " osztály tanulói:\n" + src.classRecords.listStudentNames());
                    break;
                case 2:
                    System.out.println(src.inputStudent().toString());
                    break;
                case 3:
                    System.out.println("Kérem, adja meg a diák nevét!");
                    name = scn.nextLine();
                    System.out.println(src.classRecords.addStudent(new Student(name)) ? "Sikeres művelet" : "Már van ilyen tanuló");
                    break;
                case 4:
                    System.out.println(src.classRecords.removeStudent(src.inputStudent()) ? "Sikeres művelet" : "Nincs ilyen tanuló");
                    break;
                case 5:
                    student = src.classRecords.repetition();
                    System.out.println("Kérem " + student.getName() + " osztályzatát: ");
                    Mark mark = new Mark(src.inputMarkType(), src.inputSubject(), src.inputTutor());
                    student.grading(mark);
                    break;
                case 6:
                    System.out.println("A " + src.classRecords.getClassName() + " osztály átlaga: " + src.classRecords.calculateClassAverage());
                    break;
                case 7:
                    subject = src.inputSubject();
                    System.out.println(String.format("A %s osztály %s átlaga: ", src.classRecords.getClassName(), subject.getSubjectName()) + src.classRecords.calculateClassAverageBySubject(subject));
                    break;
                case 8:
                    List<StudyResultByName> studyResult = src.classRecords.listStudyResults();
                    for (StudyResultByName srbn : studyResult) {
                        System.out.println(srbn.getStudentName() + " átlaga: " + srbn.getStudyAverage());
                    }
                    break;
                case 9:
                    student = src.inputStudent();
                    d = student.calculateAverage();
                    System.out.println(String.format("%s átlaga %4.2f", student.getName(), d));
                    break;
                case 10:
                    student = src.inputStudent();
                    subject = src.inputSubject();
                    d = student.calculateSubjectAverage(subject);
                    System.out.println(String.format("%s átlaga %s-ból: %4.2f",
                            student.getName(), subject.getSubjectName(), d));
                    break;
            }
        }
        while (i != 11);
    }
}
