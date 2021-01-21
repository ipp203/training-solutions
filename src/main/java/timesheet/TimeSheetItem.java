package timesheet;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeSheetItem {
    private final Employee employee;
    private final Project project;
    private final LocalDateTime beginDate;
    private final LocalDateTime endDate;

    public TimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        if (!endDate.toLocalDate().equals(beginDate.toLocalDate())) {
            throw new IllegalArgumentException("Dates must be on the same day!");
        }

        if (endDate.isBefore(beginDate)) {
            throw new IllegalArgumentException("End date can not be earlier than begin date!");
        }

        this.employee = employee;
        this.project = project;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return new Employee(employee);
    }

    public Project getProject() {
        return new Project(project);
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public long hoursBetweenDates() {
        return Duration.between(beginDate, endDate).toHours();
    }
}
