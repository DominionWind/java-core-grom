package lesson30.HomeWork;

import java.util.ArrayList;

public class EmployeeDAO {

    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Employee> employeesByProject(String projectName) {

        ArrayList<Employee> employeesByProject = new ArrayList<>();

        for (Employee employee : employees) {
            ArrayList<Project> projects = employee.getProjects();
            for (Project project : projects) {
                if (projectName.equals(project.getName())) {
                    employeesByProject.add(employee);
                }
            }
        }

        return employeesByProject;
    }

    public ArrayList<Project> projectsByEmployee(Employee employee) {

        ArrayList<Project> projectsByEmployee = employee.getProjects();

        return projectsByEmployee;
    }

    public ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {

        ArrayList<Employee> employeesByDepartmentWithoutProject = new ArrayList<>();

        for (Employee employee : employees) {
            if (departmentType.equals(employee.getDepartment().getType()) && employee.getProjects() == null) {
                employeesByDepartmentWithoutProject.add(employee);
            }
        }

        return employeesByDepartmentWithoutProject;
    }

    public ArrayList<Employee> employeesWithoutProject() {

        ArrayList<Employee> employeesWithoutProject = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getProjects() == null) {
                employeesWithoutProject.add(employee);
            }
        }

        return employeesWithoutProject;
    }

    public ArrayList<Employee> employeesByTeamLead(Employee lead) throws Exception {

        ArrayList<Employee> employeesByTeamLead = new ArrayList<>();

        if (lead.getPosition() != Position.TEAM_LEAD) {
            throw new Exception("Employee " + lead.getFirstName() + " " + lead.getLastName() + " not TeamLead. To get this list please chose TeamLead");
        }

        for (Employee employee : employees) {
            if (employee.getProjects() == lead.getProjects()){
                employeesByTeamLead.add(employee);
            }
        }

        employeesByTeamLead.remove(lead);
        return employeesByTeamLead;
    }

    public ArrayList<Employee> teamLeadsByEmployee(Employee employee){

        ArrayList<Employee> teamLeadsByEmployee = new ArrayList<>();

        for (Employee em:employees){
            if (em.getProjects() == employee.getProjects() && em.getPosition().equals(Position.TEAM_LEAD));
            teamLeadsByEmployee.add(em);
        }

        return teamLeadsByEmployee;
    }

    public ArrayList<Employee> employeesByPrijectEmployee(Employee employee){

        ArrayList<Employee> employeesByPrijectEmployee = new ArrayList<>();

        for (Employee em:employees){
            if (em.getProjects() == employee.getProjects()){
                employeesByPrijectEmployee.add(em);
            }
        }

        return employeesByPrijectEmployee;
    }

    public ArrayList<Employee> employeesByCustomerProjects(Customer customer){
        ArrayList<Employee> employeesByCustomerProjects = new ArrayList<>();

        for (Employee employee:employees){
            ArrayList<Project> projects = employee.getProjects();
            for (Project project:projects){
                if (customer.equals(project.getCustomer())){
                    employeesByCustomerProjects.add(employee);
                }
            }
        }

        return employeesByCustomerProjects;
    }
}
