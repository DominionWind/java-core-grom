package lesson35.model;

import java.time.LocalDate;

public class Filter {
    private int numbersOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private LocalDate dateAvailableFrom;
    private String country;
    private String city;

    public Filter(int numbersOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed,
                  LocalDate dateAvailableFrom, String country, String city) {
        this.numbersOfGuests = numbersOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.country = country;
        this.city = city;
    }

    public int getNumbersOfGuests() {
        return numbersOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public LocalDate getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}
