package gromcode.main.lesson30.HomeWork;

import java.util.ArrayList;

public class CustomerDAO {

    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void deleteCustomer(Customer customer) {
        customers.remove(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
