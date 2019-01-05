package lesson35.DAO;

import lesson35.model.Filter;
import lesson35.model.Room;

public class FilterDAO {
    public boolean confirmedRoom (Filter filter, Room room){
        if (filter.getNumbersOfGuests() != 0 && filter.getNumbersOfGuests() != room.getNumbersOfGuests()){
            return false;
        }
        if (filter.getPrice() != 0 && filter.getPrice() != room.getPrice()){
            return false;
        }
        if (filter.getCity() != null && filter.getCity() != room.getHotel().getCity()){
            return false;
        }
        if (filter.isBreakfastIncluded() != room.isBreakfastIncluded()){
            return false;
        }
        if (filter.isPetsAllowed() != room.isPetsAllowed()){
            return false;
        }
        if (filter.getCountry() != null && filter.getCountry() != room.getHotel().getCountry()){
            return false;
        }
        if (filter.getDateAvailableFrom() != null && filter.getDateAvailableFrom() != room.getDateAvailableFrom()){
            return false;
        }
        return true;
    }
}
