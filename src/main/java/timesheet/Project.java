package timesheet;

import java.util.Objects;

public class Project {
    private final String name;

    public Project(String name) {
        this.name = name;
    }

    public Project(Project project) {
        this.name = project.name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
