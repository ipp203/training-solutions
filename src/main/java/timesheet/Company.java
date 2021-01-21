package timesheet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Company {
    List<Project> projects;
    List<Employee> employees;
    List<TimeSheetItem> timeSheetItems;


    public Company(InputStream employeesFile, InputStream projectsFile) {
        projects = getProjectsFromFile(projectsFile);
        employees = getEmployeesFromFile(employeesFile);
        timeSheetItems = new ArrayList<>();
    }

    public List<Project> getProjects() {
        return List.copyOf(projects);
    }

    public List<Employee> getEmployees() {
        return List.copyOf(employees);
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        timeSheetItems.add(new TimeSheetItem(employee, project, beginDate, endDate));
    }

    public List<ReportLine> calculateProjectByNameYearMonth(String employeeName, int year, int month) {
        if (!isNameInEmployeeList(employeeName)) {
            throw new IllegalArgumentException("The name is not included in the company's employees.");
        }
        List<ReportLine> result = createReportLineListWithProjects();
        for (TimeSheetItem item : timeSheetItems) {
            if (isNameYearMonthInTimeSheetItem(item, employeeName, year, month)) {
                incReportLine(result, item.getProject(), item.hoursBetweenDates());
            }
        }
        return result;
    }

    public void printToFile(String employeeName, int year, int month, Path file) {
        List<ReportLine> result = calculateProjectByNameYearMonth(employeeName, year, month);

        long sumOfHours = sumOfHours(result);
//        try(PrintWriter pw = new PrintWriter(file.toFile(), StandardCharsets.UTF_8)){
//
//            pw.printf("%s\t%d-%02d\t%d", employeeName, year, month, sumOfHours);
//            pw.println();
//            for (ReportLine line : result) {
//                if (line.getTime() > 0) {
//                    pw.println(line.toString());
//                }
//            }

        try (BufferedWriter bw = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            bw.write(String.format("%s\t%d-%02d\t%d\n", employeeName, year, month, sumOfHours));
            for (ReportLine line : result) {
                if (line.getTime() > 0) {
                    bw.write(line.toString() + "\n");
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    private List<ReportLine> createReportLineListWithProjects() {
        List<ReportLine> result = new ArrayList<>();
        for (Project project : projects) {
            result.add(new ReportLine(project, 0));
        }
        return result;
    }

    private boolean isNameYearMonthInTimeSheetItem(TimeSheetItem item, String employeeName, int year, int month) {
        return item.getEmployee().getName().equals(employeeName) &&
                item.getBeginDate().getYear() == year &&
                item.getBeginDate().getMonth() == Month.of(month);
    }

    private void incReportLine(List<ReportLine> list, Project project, long hours) {
        for (ReportLine reportLine : list) {
            if (reportLine.getProject().equals(project)) {
                reportLine.addTime(hours);
            }
        }
    }

    private boolean isNameInEmployeeList(String name) {
        if (name == null) {
            return false;
        }
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private long sumOfHours(List<ReportLine> list) {
        long result = 0;
        for (ReportLine line : list) {
            result += line.getTime();
        }
        return result;
    }

    private List<Project> getProjectsFromFile(InputStream projectsFile) {
        List<Project> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(projectsFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.add(new Project(line));
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
        return result;
    }

    private List<Employee> getEmployeesFromFile(InputStream employeesFile) {
        List<Employee> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(employeesFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                result.add(new Employee(data[0], data[1]));
            }
        }catch(ArrayIndexOutOfBoundsException aiob){
            throw new IllegalStateException("Wrong line in file",aiob);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
        return result;
    }
}
