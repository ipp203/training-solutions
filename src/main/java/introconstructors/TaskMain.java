package introconstructors;

public class TaskMain {
    public static void main(String[] args) {
        Task task = new Task("Programozas", "Java feladat megoldas");
        task.setDuration(100000);
        task.start();

        System.out.println(task.getTitle() + " - " + task.getDescription());
        System.out.println(task.getStartLocalDate().toString());
    }
}
