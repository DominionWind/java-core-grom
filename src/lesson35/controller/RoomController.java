package lesson35.controller;

import lesson35.DAO.FilterDAO;
import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.servise.RoomService;

import java.util.ArrayList;

public class RoomController {
    RoomService roomService = new RoomService();
    FilterDAO filterDAO = new FilterDAO();

    public ArrayList<Room> findRooms(Filter filter) throws Exception {

        return filterDAO.findRooms(filter);
    }

    public void bookRoom(long RoomId, long userId, long hotelId) throws Exception {
        roomService.bookRoom(RoomId, userId, hotelId);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        roomService.cancelReservation(roomId, userId);
    }

    public void addRoom(Room room) throws Exception {
        roomService.addRoom(room);
    }

    public void deleteRoom(long roomId) throws Exception {
        roomService.deleteRoom(roomId);
    }
}
