package lesson10.abstractBigExample;

public abstract class Employee {
    private String name;
    private int age;
    private int yearsOfExperiance;

    private String curPosition;

    private int salaryPerMonth;
    private BankAccount bankAccount;
    private Company[] companiesWorked = new Company[10] ;
    private String[] positionWorked = new String[10];

    abstract void pauSalary();

    void changePosition(String newPosition){
        saveCurPositionToHistory();
        curPosition = newPosition;
    }

    private void saveCurPositionToHistory(){
        int index = 0;
        for(String pos: positionWorked){
            if (pos == null) {
                positionWorked[index] = curPosition;
                break;
            }
            index++;
        }
    }

    int getBalanse(){
        return  bankAccount.getBalance();
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public String getName() {
        return name;
    }
}
