package debug;

import java.util.ArrayList;
import java.util.List;

public class CompanyMain {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Company company = new Company(employees);

        company.addEmployee(new Employee("Aladar", 1970));
        company.addEmployee(new Employee("Bladar", 1971));
        company.addEmployee(new Employee("Cladar", 1972));
        company.addEmployee(new Employee("Dladar", 1973));
        company.addEmployee(new Employee("Eladar", 1974));

        Employee anyEmployee = company.findEmployeeByName("Dladar");
        System.out.println(anyEmployee.getName() + " " + anyEmployee.getYearOfBirth() + ".");

        System.out.println(company.listEmployeeNames());
    }
}
