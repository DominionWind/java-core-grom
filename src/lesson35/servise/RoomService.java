package lesson35.servise;

import lesson35.DAO.*;
import lesson35.Login.Utils;
import lesson35.model.Hotel;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class RoomService {

    private RoomDAO roomDAO = new RoomDAO();
    private UserDAO userDAO = new UserDAO();
    private HotelDAO hotelDAO = new HotelDAO();
    private OrderDAO orderDAO = new OrderDAO();
    private DAO dao = new DAO();
    private Utils utils = new Utils();

    public void addRoom(Room room) throws Exception {
        dao.checkAdminRights();
        roomDAO.addRoom(room);
    }

    public void deleteRoom(long roomId) throws Exception {
        dao.checkAdminRights();
        roomDAO.deleteRoom(roomId);
    }

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        Room room = roomDAO.getRoomById(roomId);
        User user = userDAO.getUserById(userId);
        Hotel hotel = hotelDAO.getHotelById(hotelId);// Зачем нам отель? В ордере нет такой сущности.
        LocalDate date = LocalDate.now();

        if (room.getDateAvailableFrom().isBefore(date)) {
            throw new Exception("This room is not available now. Room will be available from " + room.getDateAvailableFrom());
        }

        Long id = utils.createUniqueId();
        LocalDate dateFrom = utils.stringToDateConvector(printDate());
        LocalDate dateTo = utils.stringToDateConvector(printDate());
        Double moneyPaid = dateDiff(dateTo, dateFrom) * room.getPrice();

        Order order = new Order(id, user, room, dateFrom, dateTo, moneyPaid);
        orderDAO.addOrder(order); //todo поменять на ордер.сервис. Дописать сервис ордеров
        updateRoomDate(roomId, dateTo);

        System.out.println(room.toString() + moneyPaid);
    }

    private int dateDiff(LocalDate dateTo, LocalDate dateFrom) throws Exception {
        int dateDiff;
        Period period = Period.between(dateTo, dateFrom);

        dateDiff = period.getDays();

        if (dateDiff == 0) {
            dateDiff = 1;
        }

        if (dateDiff < 0) {
            throw new Exception("Please enter correct date");
        }
        return dateDiff;
    }

    private String printDate() {
        String text;
        System.out.println("Please enter date (dd-MM-yyyy)");
        Scanner scanner = new Scanner(System.in);
        return text = scanner.nextLine();
    }

    private void updateRoomDate(Long roomId, LocalDate date) throws Exception {
        Room oldRoom = roomDAO.getRoomById(roomId);
        Room newRoom = oldRoom;
        newRoom.setDateAvailableFrom(date);

        deleteRoom(roomId);
        addRoom(newRoom);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {

        Room room = roomDAO.getRoomById(roomId);
        User user = userDAO.getUserById(userId);
        Double moneyReturned = Double.valueOf(0);

            for (Order o : orderDAO.readOrderFromFile()) {
                if (o.getRoom().equals(room) && o.getUser().equals(user)) {
                    orderDAO.deleteOrder(o.getId());
                    updateRoomDate(roomId, LocalDate.now());
                }
            }

        if (dateDiff(room.getDateAvailableFrom(), LocalDate.now()) > 1){
            moneyReturned = dateDiff(room.getDateAvailableFrom(), LocalDate.now())* room.getPrice();
        }

        System.out.println(moneyReturned);
    }
}
