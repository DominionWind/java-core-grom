package lesson12;

public class UkrainianBankSystem implements BankSystem {
    //private String withdrawalEroMsq = "Can`t withdraw money " + amount + " from user " + user.toString()

    @Override
    public void withdraw(User user, int amount) {
//        int limitOfWithdrawal = user.getBank().getLimitOfFunding();
//        if (amount + user.getBank().getCommission(amount)> limitOfWithdrawal){
//            printWithdrawalEroMsq(user, amount);
//            return;
//        }
//        if (amount + user.getBank().getCommission(amount)> user.getBalance()){
//            printWithdrawalEroMsq(user, amount);
//            return;
//        }
        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    }

    @Override
    public void fund(User user, int amount) {
        if (!checkFund(user, amount))
            return;
        user.setBalance(user.getBalance() + amount);
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
}
