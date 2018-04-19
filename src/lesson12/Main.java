package lesson12;

public class Main {
    public static void main(String[] args) {
        Bank euBank = new USBank(1222,"Sweden",Currency.EUR,100,1400,4, 884343434);
        Bank usBank = new USBank(1223,"Boston",Currency.USD,100,1400,4, 994343434);
        Bank chinaBank = new USBank(1224,"Guanjou",Currency.USD,100500,14,1, 5543434);

        User user1 = new User(1001, "Denis",12200,40,"GMD",1500,euBank);
        User user2 = new User(1002, "Pasha",2200,50,"Google",100500,usBank);
        User user3 = new User(1003, "Kolia",345347,10,"DownHous",15,chinaBank);

        BankSystem bankSystem = new UkrainianBankSystem();

        bankSystem.paySalary(user1);
        bankSystem.paySalary(user2);
        bankSystem.paySalary(user3);

        bankSystem.withdraw(user1,150);

        System.out.println(user1.getBalance());
        System.out.println(user2.getBalance());
        System.out.println(user3.getBalance());

        bankSystem.transferMoney(user1,user2,15000000);
        System.out.println(user1.getBalance());
        System.out.println(user2.getBalance());

        bankSystem.withdraw(user3,15151515);
        System.out.println(user3.getBalance());

        bankSystem.fund(user1,50000);
        System.out.println(user1.getBalance());



    }
}
