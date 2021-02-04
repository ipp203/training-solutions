package week14.d04;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class EmployeesConvert {

    public List<Employee> convert(List<Employee> employees){
        return employees.stream()
                .map(e ->{
                    return new Employee(e.getName().toUpperCase());
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        EmployeesConvert ec = new EmployeesConvert();
        List<Employee> employees = Arrays.asList(
                new Employee("John Doe"),
                new Employee("Jack Doe"),
                new Employee("Jane Doe"),
                new Employee("Criss Doe")

        );
        System.out.println(employees);
        System.out.println(ec.convert(employees));
    }
}
