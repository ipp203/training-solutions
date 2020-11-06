package intromethods;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee employee = new Employee("Pal",2000,100_000);
        System.out.println(employee);

        employee.raiseSalary(12345);
        System.out.println(employee);

        employee.setName("Peter");
        System.out.println(employee);
    }
}
