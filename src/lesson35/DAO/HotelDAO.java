package lesson35.DAO;

import lesson35.model.Hotel;

import java.io.*;
import java.util.ArrayList;

public class HotelDAO {

    private DAO<Hotel> dao = new DAO<Hotel>() {
        @Override
        public Hotel convector(String string) throws Exception {
            String[] mod = string.split(",");

            long id = Long.parseLong(mod[0]);
            String hotelName = mod[1];
            String country = mod[2];
            String city = mod[3];
            String street = mod[4];

            Hotel hotel = new Hotel(id, hotelName, country, city, street);

            return hotel;
        }
    };

    private static String path = "E:\\Games\\java\\Hotel.txt";

    public void addHotel(Hotel hotel) {
        writeHotelToDB(hotel);
    }

    public void deleteHotel(long hotelId) throws Exception {
        ArrayList<Hotel> hotels = readHotelFromFile();
        hotels.remove(getHotelById(hotelId));
        saveHotelsToDb(hotels);
    }

    private void writeHotelToDB(Hotel hotel) {
        dao.writerToFile(hotel, path);
    }

    public void saveHotelsToDb(ArrayList<Hotel> hotels) throws Exception {
        deleteHotelsFromDB();
        for (Hotel h : hotels) {
            writeHotelToDB(h);
        }
    }

    public Hotel getHotelById(Long id) throws Exception {
        for (Hotel h : readHotelFromFile()) {
            if (h.getId() == id) {
                return h;
            }
        }
        throw new Exception("Can`t find Hotel whit ID " + id);
    }

    public Hotel findHotelByName(String name) throws Exception {
        for (Hotel h : readHotelFromFile()) {
            if (h.getName().equals(name))
                return h;
        }
        throw new Exception("Can`t find Hotel whit name " + name);
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {

        if (city.equals(null)) {
            return null;
        }

        ArrayList<Hotel> hotels = new ArrayList<>();

        for (Hotel h : readHotelFromFile()) {
            if (h.getCity().equals(city)) {
                hotels.add(h);
            }
        }
        return hotels;
    }

    public ArrayList<Hotel> readHotelFromFile() throws Exception {
        return dao.readFromFile(path);
    }

    private void deleteHotelsFromDB() throws FileNotFoundException {
        dao.deleteContent(path);
    }
}
