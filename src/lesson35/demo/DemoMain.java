package lesson35.demo;

import lesson35.DAO.HotelDAO;
import lesson35.DAO.UserDAO;
import lesson35.Login.Start;
import lesson35.controller.HotelController;
import lesson35.controller.RoomController;
import lesson35.controller.UserController;
import lesson35.model.Hotel;

public class DemoMain {
    public static void main(String[] args) throws Exception {
        UserDAO userDAO = new UserDAO();
        UserController userController = new UserController();
        RoomController roomController = new RoomController();
        HotelController hotelController = new HotelController();
        HotelDAO hotelDAO = new HotelDAO();
        Start start = new Start();
        Hotel hotel = new Hotel(20001, "Hotel1","UA","Kiev","AAA");

//        hotelDAO.addHotel(hotel);
//        hotelDAO.addHotel(hotel);
//        hotelDAO.addHotel(hotel);
//        hotelDAO.addHotel(hotel);

//        System.out.println(hotelController.findHotelByName("Hotel1"));
//        System.out.println(hotelController.findHotelByCity("Kiev"));

//        System.out.println(userDAO.getUserById(10002));
        System.out.println(userDAO.readUserFromFile());


//        System.out.println(start.getLoggedInUser());
   }
}
