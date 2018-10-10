package gromcode.main.lesson30.HomeWork;

import java.util.ArrayList;

public class Controller {

    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private ProjectDAO projectDAO = new ProjectDAO();

    public void addEmployee(Employee employee){
        employeeDAO.addEmployee(employee);
    }

    public void addProject(Project project){
        projectDAO.addProject(project);
    }

    public void deleteEmployee(Employee employee){
        employeeDAO.deleteEmployee(employee);
    }

    public void deleteProject(Project project){
        projectDAO.deleteProject(project);
    }

    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public ProjectDAO getProjectDAO() {
        return projectDAO;
    }

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

    public ArrayList<Employee> teamLeadsByEmployee(Employee employee){
        return employeeDAO.teamLeadsByEmployee(employee);
    }
}
