package lesson20.task2;

import lesson20.task2.exeption.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws LimitExceeded {

        //todo
        return transaction;
    }

    private void validate(Transaction transaction) throws Exception{
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ".Can`t be saved");

        int sum = 0;
        int count=0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum > utils.getLimitSimpleTransactionAmount()) {
            throw new LimitExceeded("Transaction limit per dae amount exceed " + transaction.getId() + ".Can`t be saved");
        }

        if (count > utils.getLimitSimpleTransactionAmount()){
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ".Can`t be saved");
        }

        //todo
    }

    Transaction[] transactionList() {

        return null;
    }

    Transaction[] transactionList(String city) {

        return null;
    }

    Transaction[] transactionList(int amount) {

        return null;
    }

    private Transaction[] getTransactionsPerDay(Date dateOdCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOdCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }

}
