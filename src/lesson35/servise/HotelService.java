package lesson35.servise;

import lesson35.DAO.HotelDAO;
import lesson35.Login.Start;
import lesson35.model.Hotel;

import java.io.File;
import java.util.ArrayList;

public class HotelService {

    private HotelDAO hotelDAO = new HotelDAO();
    private Start start = new Start();

    public void addHotel(Hotel hotel) throws Exception {
        start.checkAdminRights();
        hotelDAO.addHotel(hotel);
    }

    public void deleteHotel(long hotelId) throws Exception {
        start.checkAdminRights();
        hotelDAO.deleteHotel(hotelId);
    }

    public Hotel findHotelByName(String name) throws Exception {
        return hotelDAO.findHotelByName(name);
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        return hotelDAO.findHotelByCity(city);
    }

    public Hotel registerHotel(Hotel hotel) throws Exception {
        hotelCheck(hotel);
        hotelValidator(hotel);

        hotelDAO.addHotel(hotel);
        return hotel;
    }

    private void hotelCheck(Hotel hotel) throws Exception {
        for (Hotel h : hotelDAO.readHotelFromFile()) {
            if (hotel.getName().equals(h.getName())) {
                throw new Exception("Hotel " + h.getName() + " already in bd");
            }
        }
    }

    private void hotelValidator(Hotel hotel) throws Exception {
        if (hotel.getName() == null) {
            throw new Exception("hotel name can`t be null");
        }

        if (hotel.getCity() == null) {
            throw new Exception("hotel city can`t be null");
        }

        if (hotel.getCountry() == null) {
            throw new Exception("hotel country can`t be null");
        }

        if (hotel.getStreet() == null) {
            throw new Exception("hotel street can`t be null");
        }
    }

    private void fileUserExist() throws Exception {
        File f = new File("E:\\Games\\java\'Hotel.txt");
        if (!f.exists())
            throw new Exception("File User.txt does not exist");
    }
}
