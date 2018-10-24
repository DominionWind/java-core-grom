package lesson35.model;

import java.time.LocalDate;

public class Room {
    private long id;
    private int numbersOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private LocalDate dateAvailableFrom;
    private Hotel hotel;

    public Room(long id, int numbersOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, LocalDate dateAvailableFrom, Hotel hotel) {
        this.id = id;
        this.numbersOfGuests = numbersOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumbersOfGuests() {
        return numbersOfGuests;
    }

    public void setNumbersOfGuests(int numbersOfGuests) {
        this.numbersOfGuests = numbersOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public LocalDate getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public void setDateAvailableFrom(LocalDate dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", numbersOfGuests=" + numbersOfGuests +
                ", price=" + price +
                ", breakfastIncluded=" + breakfastIncluded +
                ", petsAllowed=" + petsAllowed +
                ", dateAvailableFrom=" + dateAvailableFrom +
                ", hotel=" + hotel +
                '}';
    }
}
