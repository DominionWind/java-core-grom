package lesson35.model;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    private long id;
    private User user;
    private Room room;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private double moneyPaid;

    public Order(long id, User user, Room room, LocalDate dateFrom, LocalDate dateTo, double moneyPaid) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", room=" + room +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", moneyPaid=" + moneyPaid +
                '}';
    }
}
