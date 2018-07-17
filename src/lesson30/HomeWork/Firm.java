package lesson30.HomeWork;


import java.util.Collection;
import java.util.Date;

public class Firm {
    private Date dataFounded;
    private Collection departments;
    private Collection customers;

    public Firm(Date dataFounded, Collection departments, Collection customers) {
        this.dataFounded = dataFounded;
        this.departments = departments;
        this.customers = customers;
    }

    public void setDepartments(Collection departments) {
        this.departments = departments;
    }

    public void setCustomers(Collection customers) {
        this.customers = customers;
    }

    public Date getDataFounded() {

        return dataFounded;
    }

    public Collection getDepartments() {
        return departments;
    }

    public Collection getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "dataFounded=" + dataFounded +
                ", departments=" + departments +
                ", customers=" + customers +
                '}';
    }
}
