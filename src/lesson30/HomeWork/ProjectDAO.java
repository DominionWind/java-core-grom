package lesson30.HomeWork;

import java.util.ArrayList;

public class ProjectDAO {

    private ArrayList<Project> projects = new ArrayList<>();

    public void addProject(Project project) {
        projects.add(project);
    }

    public void deleteProject(Project project) {
        projects.remove(project);
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public ArrayList<Project> projectsByCustomer(Customer customer) {
        ArrayList<Project> projectsByCustomer = new ArrayList<>();

        for (Project project : projects) {
            if (project != null && customer.equals(project.getCustomer())) {
                projectsByCustomer.add(project);
            }
        }

        return projectsByCustomer;
    }
}
