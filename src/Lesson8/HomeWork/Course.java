package Lesson8.HomeWork;

import java.util.Date;

public class Course {
    Date startDate;
    String name;
    int hoursDuration;
    String teacherName;
    Student [] Students;

    public Course(Date startDate, String name, int hoursDuration, String teacherName, Student[] students) {
        this.startDate = startDate;
        this.name = name;
        this.hoursDuration = hoursDuration;
        this.teacherName = teacherName;
        Students = students;
    }

    Course course = new Course( new java.util.Date(), "Java", 100500, "MasterJava",null);
}
