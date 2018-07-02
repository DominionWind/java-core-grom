package lesson23;

public class Validator {
    private String name;
    private final int checkCount;

    public Validator(String name, int checkCount) {
        this.name = name;
        this.checkCount = checkCount;
    }

    public boolean validate(){
        return false;
    }

    public String getName() {
        return name;
    }

    public int getCheckCount() {
        return checkCount;
    }
}
