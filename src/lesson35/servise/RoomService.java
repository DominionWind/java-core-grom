package lesson35.servise;

import lesson35.DAO.HotelDAO;
import lesson35.DAO.OrderDAO;
import lesson35.DAO.RoomDAO;
import lesson35.DAO.UserDAO;
import lesson35.model.Hotel;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;

import java.util.ArrayList;
import java.util.Date;

public class RoomService {


    private RoomDAO roomDAO = new RoomDAO();
    private UserDAO userDAO = new UserDAO();
    private HotelDAO hotelDAO = new HotelDAO();
    private OrderDAO orderDAO = new OrderDAO();

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception { //todo
        Room room = roomDAO.getRoomById(roomId);
        User user = userDAO.getUserById(userId);
        Hotel hotel = hotelDAO.getHotelById(hotelId);// Зачем нам отель? В ордере нет такой сущности.
        Date date = new Date();

        if (!room.getDateAvailableFrom().after(date)) {
            throw new Exception("This room is not available now. Room will be available from " + room.getDateAvailableFrom());
        }

        Long id = (long)Math.random();
        Date dateFrom = new Date();//todo
        Date dateTo = new Date();//todo
        Double moneyPaid = dateTo.compareTo(dateFrom)*room.getPrice();//todo


        Order order = new Order(id, user, room, dateFrom, dateTo, moneyPaid) ;
        ArrayList<Order> orders = orderDAO.readOrderFromFile();
        orders.add(order);
        orderDAO.saveOrdersToDb(orders);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {

        Room room = roomDAO.getRoomById(roomId);
        User user = userDAO.getUserById(userId);

        //todo


    }


}
