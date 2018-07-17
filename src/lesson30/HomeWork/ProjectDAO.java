package lesson30.HomeWork;

import java.util.ArrayList;

public class ProjectDAO {

    private ArrayList<Project> projects = new ArrayList<>();

    public void addProject(Project project){
        projects.add(project);
    }

    public void deleteProject(Project project){
        projects.remove(project);
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }
}
