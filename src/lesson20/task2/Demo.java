package lesson20.task2;

import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        TransactionDAO transactionDAO = new TransactionDAO();

        Transaction transaction1=new Transaction(1,"Kiev",10,"someDescr",TransactionType.INCOME,new Date());
        Transaction transaction2=new Transaction(2,"Kiev",2,"someDescr",TransactionType.INCOME,new Date());
        Transaction transaction3=new Transaction(3,"Kiev",10,"someDescr",TransactionType.INCOME,new Date());
        Transaction transaction4=new Transaction(4,"Kiev",10,"someDescr",TransactionType.INCOME,new Date());
        Transaction transaction5=new Transaction(5,"Odessa",10,"someDescr",TransactionType.INCOME,new Date());
        Transaction transaction6=new Transaction(6,"Odessa",10,"someDescr",TransactionType.INCOME,new Date());
        Transaction transaction7=new Transaction(7,"Odessa",10,"someDescr",TransactionType.INCOME,new Date());
        Transaction transaction8=new Transaction(8,"Kiev",10,"someDescr",TransactionType.INCOME,new Date());
        Transaction transaction9=new Transaction(9,"Kiev",10,"someDescr",TransactionType.INCOME,new Date());
        Transaction transaction10=new Transaction(10,"Aphines",10,"someDescr",TransactionType.INCOME,new Date());

        controller.save(transaction3);
    }
}
