package lesson12;

public class UkranianBanksSystem implements BankSystem {

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
        //TODO homeWork
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (!checkWithdraw(fromUser, amount))
            return;

        //TODO check fund rules
        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        //TODO withdraw and fund
    }

    @Override
    public void paySalary(User user) {
        //TODO homeWork
    }

    private void printWithdrawalEroMsq(User user, int amount) {
        System.err.println("Can`t withdraw money " + amount + " from user " + user.toString());
    }

    private boolean checkWithdraw(User user, int amount) {
        return !checkWithdrawLimits(user, amount, user.getBank().getLimitOfFunding()) &&
                !checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalEroMsq(user, amount);
            return false;
        }
        return true;
    }
}
