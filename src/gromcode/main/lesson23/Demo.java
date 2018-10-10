package gromcode.main.lesson23;

public class Demo {
    public static void main(String[] args) {
        Validator validator1 = new Validator("user", 5);
        Validator validator2 = new Validator("company", 10);
        System.out.println(validator1.getCheckCount());
        System.out.println(validator2.getCheckCount());
    }
}
