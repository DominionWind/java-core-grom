package lesson35.model;

import java.util.Date;

public class Room {
    private long id;
    private int numbersOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    public Room(long id, int numbersOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
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

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;

        Room room = (Room) o;

        if (getId() != room.getId()) return false;
        if (getNumbersOfGuests() != room.getNumbersOfGuests()) return false;
        if (Double.compare(room.getPrice(), getPrice()) != 0) return false;
        if (isBreakfastIncluded() != room.isBreakfastIncluded()) return false;
        if (isPetsAllowed() != room.isPetsAllowed()) return false;
        if (getDateAvailableFrom() != null ? !getDateAvailableFrom().equals(room.getDateAvailableFrom()) : room.getDateAvailableFrom() != null)
            return false;
        return getHotel() != null ? getHotel().equals(room.getHotel()) : room.getHotel() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getNumbersOfGuests();
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isBreakfastIncluded() ? 1 : 0);
        result = 31 * result + (isPetsAllowed() ? 1 : 0);
        result = 31 * result + (getDateAvailableFrom() != null ? getDateAvailableFrom().hashCode() : 0);
        result = 31 * result + (getHotel() != null ? getHotel().hashCode() : 0);
        return result;
    }
}
