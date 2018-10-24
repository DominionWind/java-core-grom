package lesson35.DAO;

import lesson35.model.Hotel;

import java.io.*;
import java.util.ArrayList;

public class HotelDAO {

    public void addHotel(Hotel hotel) {
        writeHotelToDB(hotel);
    }

    public void deleteHotel(long hotelId) throws Exception {
        ArrayList<Hotel> hotels = readHotelFromFile();
        hotels.remove(getHotelById(hotelId));
        saveHotelsToDb(hotels);
    }

    private void writeHotelToDB(Hotel hotel) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter("E:\\Games\\java\'Hotel.txt", true))) {
            br.newLine();
            br.write(hotel.toString());
        } catch (IOException e) {
            System.err.println("Can`t save Hotel " + hotel.getName() + " to DB");
        }
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

        ArrayList<Hotel> hotels = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("E:\\Games\\java\'Hotel.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                hotels.add(stringToHotelConvector(line));
            }
        } catch (IOException e) {
            System.err.println("Reading from file E:\\Games\\java\'Hotel.txt failed");
        }

        return hotels;
    }

    private Hotel stringToHotelConvector(String string) {

        String[] mod = string.split(",");

        long id = Long.parseLong(mod[0]);
        String hotelName = mod[1];
        String country = mod[2];
        String city = mod[3];
        String street = mod[4];

        Hotel hotel = new Hotel(id, hotelName, country, city, street);

        return hotel;
    }

    private void deleteHotelsFromDB() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("E:\\Games\\java\'Hotel.txt");
        writer.print("");
        writer.close();
    }
}
