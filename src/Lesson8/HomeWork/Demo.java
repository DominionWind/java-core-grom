package Lesson8.HomeWork;

public class Demo extends SpecialStudent{

    public Demo(String firstName, String lastName, int group, Course[] coursesTaken, long secretKey, String email) {
        super(firstName, lastName, group, coursesTaken, secretKey, email);
    }

    Student createHighestParent() {
        Student student = new Student("Krokodil", "Gena", 1, null);
        return student;
    }

    SpecialStudent createLowestChild(){
        SpecialStudent specialStudent = new SpecialStudent("Cheburrr", "Blooddy", 0, null, 32167, null);
        return specialStudent;
    }
}
