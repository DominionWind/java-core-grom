package lesson30.HomeWork;

import java.util.ArrayList;

public class DepartmentDAO {

    private ArrayList<Department> departments = new ArrayList<>();

    public void addDepartment(Department department){
        departments.add(department);
    }

    public void deleteDepartment(Department department){
        departments.remove(department);
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }
}
