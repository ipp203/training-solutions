package week12.d05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFilterTest {

    @Test
    void countSeniorDevs() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(25, 3, "John Doe", Arrays.asList("programming", "testing")));
        employees.add(new Employee(35, 6, "Jane Doe", Collections.singletonList("testing")));
        employees.add(new Employee(45, 6, "Jack Doe", Arrays.asList("testing", "programming")));

        List<Employee> programmers = new EmployeeFilter().countSeniorDevs(employees);

        assertEquals(2, programmers.size());

    }
}