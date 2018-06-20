package lesson20.task2;

import lesson20.task2.exeption.BadRequestException;
import lesson20.task2.exeption.InternalServerException;
import lesson20.task2.exeption.LimitExceeded;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {

        validate(transaction);
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i].equals(null)) {
                transactions[i] = transaction;
                break;
            }
            else {
                throw new InternalServerException("Transaction ID# " + transaction.getId() + " can`t be saved. Not enought spase in DB");
            }
        }
        return transaction;
    }

    private void validate(Transaction transaction) throws Exception {
        if (transaction == null)
            throw new BadRequestException("Transaction ID# " + transaction.getId() + " is null!!! NOT GOING xD");

        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ".Can`t be saved");

//        for (Transaction tr : transactions) {
//            if (tr.equals(transaction))
//                throw new BadRequestException("Transaction ID#" + transaction.getId() + " is already in DB. not going again =(");
//        }

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum > utils.getLimitSimpleTransactionAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ".Can`t be saved");
        }

        if (count > utils.getLimitSimpleTransactionAmount()) {
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ".Can`t be saved");
        }

        if (!transaction.getCity().equals(utils.getCities())) {
            throw new BadRequestException("Incorect transaction ID# " + transaction.getId() + " citi direct. Transaction Faild");
        }

//        int nullCount = 0;
//        for (Transaction tr : transactions) {
//            if (tr.equals(null))
//                nullCount++;
//        }
//
//        if (nullCount == 0) {
//            throw new InternalServerException("Transaction ID# " + transaction.getId() + " can`t be saved. Not enought spase in DB");
//        }
    }

    Transaction[] transactionList() {
        System.out.println(Arrays.deepToString(transactions));
        return transactions;
    }

    Transaction[] transactionList(String city) {

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr.getCity().equals(city))
                count++;
        }

        Transaction[] transaction = new Transaction[count];

        int i = 0;
        for (Transaction tr : transaction) {
            if (tr.getCity().equals(city)) {
                transaction[i] = tr;
                i++;
            }
        }

        return transaction;
    }

    Transaction[] transactionList(int amount) {

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr.getAmount() == amount)
                count++;
        }

        Transaction[] transaction = new Transaction[count];

        int i = 0;
        for (Transaction tr : transaction) {
            if (tr.getAmount() == amount) {
                transaction[i] = tr;
                i++;
                System.out.println(i);
            }
        }

        return transaction;
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
