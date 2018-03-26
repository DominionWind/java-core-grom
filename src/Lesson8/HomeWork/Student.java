package Lesson8.HomeWork;

public class Student {
    String firstName;
    String lastName;
    int group;
    Course [] coursesTaken;
    int age;

    public Student(String firstName, String lastName, int group, Course[] coursesTaken) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.coursesTaken = coursesTaken;
    }

    //Course course = new Course(new java.util.Date(), "Java", 100500, "MasterJava",null);
    Student studentNoob = new Student("Padavan","Noob", 1,null);
}
