package lesson30.task1;

public class Demo {
    public static void main(String[] args) throws InterruptedException {

        UkrainianBankSystem bankSystem = new UkrainianBankSystem();

        Bank euBank = new EUBank(1222, "Sweden",Currency.EUR,100,1400,4,444343434);

        User user = new User(1001,"Denis",12200,40,"GMD",1500,euBank);

        bankSystem.withdraw(user,150);

        Thread.sleep(2000);

        bankSystem.withdraw(user,10);
//        bankSystem.withdraw(user,150);

        System.out.println(bankSystem.getTransactions());
    }
}
