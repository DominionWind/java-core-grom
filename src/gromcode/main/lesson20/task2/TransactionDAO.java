package gromcode.main.lesson20.task2;

import gromcode.main.lesson20.task2.exeption.BadRequestException;
import gromcode.main.lesson20.task2.exeption.InternalServerException;
import gromcode.main.lesson20.task2.exeption.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private static Transaction[] transactions = new Transaction[10];
    private static Utils utils = new Utils();

    public static Transaction save(Transaction transaction) throws Exception {

        validate(transaction);

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                transactions[i] = transaction;
                break;
            }
        }
        return transaction;
    }

    private static void validate(Transaction transaction) throws Exception {
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ".Can`t be saved");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum + transaction.getAmount() > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ".Can`t be saved");
        }

        if (count + 1 > utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ".Can`t be saved");
        }

//        if (!transaction.getCity().equals(utils.getCities())) {
//            throw new BadRequestException("Incorect transaction ID# " + transaction.getId() + " citi direct. Transaction Faild");
//        }

        boolean validateCity = false;
        for (String city : utils.getCities()) {
            if (city.equals(transaction.getCity())) {
                validateCity = true;
                break;
            }
        }

        if (!validateCity) {
            throw new BadRequestException("Transaction ID# " + transaction.getId() + " faild. Incorrect city");
        }

        int freeStotsCount = 0;
        for (Transaction tr : transactions) {
            if (tr == null) ;
            freeStotsCount++;
        }

        if (freeStotsCount <= 0) {
            throw new InternalServerException("Not enought free slots. Transaction ID# " + transaction.getId() + " faild");
        }
    }

    public static Transaction[] transactionList() {

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null)
                count++;
        }

        Transaction[] trans = new Transaction[count];

        int i = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                trans[i] = tr;
                i++;
            }
        }

        return trans;
    }

    public static Transaction[] transactionList(String city) {

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(city))
                count++;
        }

        Transaction[] trans = new Transaction[count];

        int i = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(city)) {
                trans[i] = tr;
                i++;
            }
        }

        return trans;
    }

    public static Transaction[] transactionList(int amount) {

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount)
                count++;
        }

        Transaction[] trans = new Transaction[count];

        int i = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                trans[i] = tr;
                i++;
            }
        }

        return trans;
    }

    private static Transaction[] getTransactionsPerDay(Date dateOdCurTransaction) {
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
