package stringconcat;

public class Employee {
    private String name;
    private String job;
    private int salary;
    //Kis Géza - minőségellenőr - 520000 Ft


    public Employee(String name, String job, int salary) {
        if (name != null && name.length() > 0) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name must not be empty.");
        }
        if (job != null && job.length() > 0) {
            this.job = job;
        } else {
            throw new IllegalArgumentException("Job must not be empty.");
        }
        if (salary > 0 && salary % 1000 == 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Salary must be positive.");
        }
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " - " + job + " - " + salary + " Ft";
    }
}
