package lesson30.HomeWork;

import java.util.ArrayList;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {

        Controller controller = new Controller();

        ArrayList<Employee> employees1 = new ArrayList<>();

        ArrayList<Project> projects1 = new ArrayList<>();
        ArrayList<Project> projects2 = new ArrayList<>();
        ArrayList<Project> projects3 = new ArrayList<>();

        Customer customer1 = new Customer("Kompania1", "UA", 1111);
        Customer customer2 = new Customer("Kompania2", "UK", 2222);
        Customer customer3 = new Customer("Kompania3", "BY", 3333);

        Project project1 = new Project("P1", customer1);
        Project project2 = new Project("P2", customer2);
        Project project3 = new Project("P3", customer3);

        projects1.add(project1);
        projects2.add(project2);
        projects3.add(project3);

        Department department1 = new Department(DepartmentType.DEVELOPMENT, employees1);
        Department department2 = new Department(DepartmentType.MANAGEMENT, employees1);
        Department department3 = new Department(DepartmentType.DESIGNER, employees1);

        Employee employee1 = new Employee("Devid", "Lebovski",new Date(), Position.TEAM_LEAD, department1, projects1);
        Employee employee2 = new Employee("Boris", "Razor",new Date(), Position.DEVELOPER, department1, projects1);
        Employee employee3 = new Employee("Dmitriy", "TheThird",new Date(), Position.DEVELOPER, department1, projects1);
        Employee employee4 = new Employee("Kevin", "K",new Date(), Position.MANAGER, department2, projects2);
        Employee employee5 = new Employee("Serj", "Mavrodiu",new Date(), Position.MANAGER, department1, projects2);
        Employee employee6 = new Employee("Madison", "Ivy",new Date(), Position.DESIGNER, department3, null);
        Employee employee7 = new Employee("Silvia", "Saint",new Date(), Position.DESIGNER, department3, null);

        controller.addEmployee(employee1);
        controller.addEmployee(employee2);
        controller.addEmployee(employee3);
        controller.addEmployee(employee4);
        controller.addEmployee(employee5);
        controller.addEmployee(employee6);
        controller.addEmployee(employee7);

        employees1.add(employee1);
        employees1.add(employee2);
        employees1.add(employee3);
        employees1.add(employee4);
        employees1.add(employee5);
        employees1.add(employee6);
        employees1.add(employee7);

//        System.out.println(controller.employeesByProject("P1"));

//        System.out.println(controller.projectsByEmployee(employee1));

//        System.out.println(controller.employeesByDepartmentWithoutProject(DepartmentType.DESIGNER));

//        System.out.println(controller.employeesWithoutProject());

//        System.out.println(controller.employeesByTeamLead(employee1));

//        System.out.println(controller.employeesByTeamLead(employee2));

//todo        System.out.println(controller.teamLeadsByEmployee(employee2));

//        System.out.println(controller.employeesByProjectEmployee(employee2));

//todo        System.out.println(controller.projectsByCustomer(customer1));

//todo        System.out.println(controller.employeesByCustomerProjects(customer1));


    }
}
