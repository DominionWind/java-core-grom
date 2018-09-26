package lesson35.servise;

import lesson35.DAO.HotelDAO;
import lesson35.DAO.RoomDAO;
import lesson35.DAO.UserDAO;
import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.model.User;

public class RoomService {

    private RoomDAO roomDAO = new RoomDAO();
    private UserDAO userDAO = new UserDAO();
    private HotelDAO hotelDAO = new HotelDAO();

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception{

        Room room = roomDAO.getRoomById(roomId);
        User user = userDAO.getUserById(userId);
        Hotel hotel = hotelDAO.getHotelById(hotelId);



    }

    public void cancelReservation(long roomId, long userId) throws Exception {

        Room room = roomDAO.getRoomById(roomId);
        User user = userDAO.getUserById(userId);



    }


}
