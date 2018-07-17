package lesson30.HomeWork;

import java.util.ArrayList;

public class EmployeeDAO {

    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void deleteEmployee(Employee employee){
        employees.remove(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Employee> employeesByProject(String projectName){
        ArrayList<Employee> employeesByProject = new ArrayList<>();

        for (Employee employee:employees){
            ArrayList<Project> projects = employee.getProjects();
            for (Project project : projects){
                if (projectName.equals(project.getName())){
                    employeesByProject.add(employee);
                }
                return employeesByProject;
            }
        }
        return employeesByProject;
    }
}
