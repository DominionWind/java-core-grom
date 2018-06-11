package lesson20.task2;

import java.util.Date;
import java.util.Objects;

public class Transaction {

    private long id;
    private String city;
    private int amount;
    private String description;
    private TransactionType type;
    private Date dateCreated;

    public Transaction(long id, String city, int amount, String description, TransactionType type, Date dateCreated) {
        this.id = id;
        this.city = city;
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public TransactionType getType() {
        return type;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return getId() == that.getId() &&
                getAmount() == that.getAmount() &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                getType() == that.getType();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getCity(), getAmount(), getDescription(), getType());
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
