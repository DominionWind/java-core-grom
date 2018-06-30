package lesson20.task2;

public class Controller {
    //private TransactionDAO transactionDAO = new TransactionDAO();

    public static Transaction save(Transaction transaction) throws Exception {
        return TransactionDAO.save(transaction);
    }

    Transaction[] transactionList() {
        return TransactionDAO.transactionList();
    }

    Transaction[] transactionList(String city) {
        return TransactionDAO.transactionList(city);
    }

    Transaction[] transactionList(int amount) {
        return TransactionDAO.transactionList(amount);
    }
}
