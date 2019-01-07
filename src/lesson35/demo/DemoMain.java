package lesson35.demo;

import lesson35.DAO.HotelDAO;
import lesson35.Login.Start;
import lesson35.controller.HotelController;
import lesson35.controller.RoomController;
import lesson35.controller.UserController;
import lesson35.model.Hotel;

public class DemoMain {
    public static void main(String[] args) throws Exception {
        UserController userController = new UserController();
        RoomController roomController = new RoomController();
        HotelController hotelController = new HotelController();
        HotelDAO hotelDAO = new HotelDAO();
        Start start = new Start();
        Hotel hotel = new Hotel(20001, "Hotel1","UA","Kiev","AAA");


    }
}
