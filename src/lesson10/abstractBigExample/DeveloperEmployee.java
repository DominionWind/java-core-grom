package lesson10.abstractBigExample;

public class DeveloperEmployee extends Employee{
    private String[] frameworks = new String[10];

    @Override
    void pauSalary() {
        int newBalance = getBankAccount().getBalance() + getSalaryPerMonth() + 1000;
        getBankAccount().setBalance(newBalance);
    }
}
