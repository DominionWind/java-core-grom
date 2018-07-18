package lesson30.HomeWork;

import java.util.ArrayList;

public class Controller {

    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private ProjectDAO projectDAO = new ProjectDAO();

    public ArrayList<Employee> employeesByProject(String projectName) {
        return employeeDAO.employeesByProject(projectName);
    }

    public ArrayList<Project> projectsByEmployee(Employee employee) {
        return employeeDAO.projectsByEmployee(employee);
    }

    public ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType){
        return employeeDAO.employeesByDepartmentWithoutProject(departmentType);
    }

    public ArrayList<Employee> employeesWithoutProject(){
        return employeeDAO.employeesWithoutProject();
    }

    public ArrayList<Employee> employeesByTeamLead(Employee lead) throws Exception{
        return employeeDAO.employeesByTeamLead(lead);
    }

    public ArrayList<Employee> employeesByProjectEmployee(Employee employee){
        return employeeDAO.employeesByProjectEmployee(employee);
    }

    public ArrayList<Employee> employeesByCustomerProjects(Customer customer){
        return employeeDAO.employeesByCustomerProjects(customer);
    }

    public ArrayList<Project> projectsByCustomer(Customer customer){
        return projectDAO.projectsByCustomer(customer);
    }
}
