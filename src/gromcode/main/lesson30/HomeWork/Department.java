package gromcode.main.lesson30.HomeWork;

import java.util.Collection;

public class Department {
    private DepartmentType type;
    private Collection employees;

    public Department(DepartmentType type, Collection employees) {
        this.type = type;
        this.employees = employees;
    }

    public void setEmployees(Collection employees) {
        this.employees = employees;
    }

    public DepartmentType getType() {
        return type;
    }

    public Collection getEmployees() {
        return employees;
    }
}
