package gromcode.main.lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(), TransactionType.WITHDRAWAL,amount,"sdsdc");
    }

    @Override
    public void fund(User user, int amount) {
        if (!checkFund(user, amount))
            return;
        user.setBalance(user.getBalance() + amount);

        createAndSaveTransaction(new Date(), TransactionType.FUNDING,amount,"sdsdc");
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (!checkWithdraw(fromUser, amount))
            return;
        if (!checkFund(toUser, amount))
            return;
        if (fromUser.getBank().getCurrency() == toUser.getBank().getCurrency()) {
            withdraw(fromUser, amount);
            fund(toUser, amount);
        } else
            System.out.println("FATAL ERROR!!! TRANSACTION NOT GOING!!! INDIAN CODE NOT WORKING");
    }

    @Override
    public void paySalary(User user) {
        if (!checkFund(user, user.getSalary()))
            return;
        fund(user, user.getSalary());
    }

    private void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money " + amount + " from user" + user.toString());
    }

    private void printFundErrorMsg(int amount, User user) {
        System.err.println("Can't fund money " + amount + " to user" + user.toString());
    }

    private boolean checkFund(User user, int amount) {
        if (amount + user.getBank().getCommission(amount) > user.getBank().getLimitOfFunding()) {
            printFundErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private Transaction createAndSaveTransaction(Date dateCreated, TransactionType type, int amount, String descr){
        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), dateCreated, null, type, amount, descr);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
