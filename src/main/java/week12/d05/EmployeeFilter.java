package week12.d05;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFilter {

    public List<Employee> countSeniorDevs(List<Employee> employees) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getSkills().contains("programming") && emp.getSkillLevel() > 2) {
                result.add(emp);
            }
        }
        return result;
    }
}
