package lesson8.HomeWork;

public class SpecialStudent extends CollegeStudent{
    long secretKey;
    String email;

    public SpecialStudent(String firstName, String lastName, int group, Course[] coursesTaken, long secretKey, String email) {
        super(firstName, lastName, group, coursesTaken);
        this.secretKey = secretKey;
        this.email = email;
    }

    SpecialStudent studentMaster = new SpecialStudent("Dart", null, 0, null, 32167,null);
}
