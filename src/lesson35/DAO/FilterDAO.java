package lesson35.DAO;

import lesson35.model.Filter;
import lesson35.model.Room;

import java.util.ArrayList;

public class FilterDAO {
    RoomDAO roomDAO = new RoomDAO();

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        ArrayList<Room> rooms = new ArrayList<>();
        for (Room r : roomDAO.readRoomFromFile()) {
            if (confirmedRoom(filter, r) == true){
                rooms.add(r);
            }
        }
        return rooms;
    }

    private boolean confirmedRoom(Filter filter, Room room) {
        if (filter.getNumbersOfGuests() != 0 && filter.getNumbersOfGuests() != room.getNumbersOfGuests()) {
            return false;
        }
        if (filter.getPrice() != 0 && filter.getPrice() != room.getPrice()) {
            return false;
        }
        if (filter.getCity() != null && filter.getCity() != room.getHotel().getCity()) {
            return false;
        }
        if (filter.isBreakfastIncluded() != room.isBreakfastIncluded()) {
            return false;
        }
        if (filter.isPetsAllowed() != room.isPetsAllowed()) {
            return false;
        }
        if (filter.getCountry() != null && filter.getCountry() != room.getHotel().getCountry()) {
            return false;
        }
        if (filter.getDateAvailableFrom() != null && filter.getDateAvailableFrom() != room.getDateAvailableFrom()) {
            return false;
        }
        return true;
    }
}
