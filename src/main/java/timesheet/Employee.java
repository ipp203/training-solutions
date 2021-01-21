package timesheet;

public class Employee {
    private final String firstname;
    private final String lastname;

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Employee(Employee employee) {
        this.firstname = employee.firstname;
        this.lastname = employee.lastname;
    }

    public String getName() {
        return firstname + " " + lastname;
    }


}
