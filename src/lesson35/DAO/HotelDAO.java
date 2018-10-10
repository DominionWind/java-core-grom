package lesson35.DAO;

import lesson35.Login.Start;
import lesson35.model.Hotel;
import lesson35.model.UserType;

import java.io.*;
import java.util.ArrayList;

public class HotelDAO {

    Start start = new Start();

    public void addHotel(Hotel hotel) throws Exception{
        checkAdmin();
        ArrayList<Hotel> hotels = readHotelFromFile();
        hotels.add(hotel);
        saveHotelsToDb(hotels);
    }

    public void deleteHotel(long hotelId) throws Exception {
        checkAdmin();
        ArrayList<Hotel>hotels = readHotelFromFile();
        hotels.remove(getHotelById(hotelId));
        saveHotelsToDb(hotels);
    }

    public void saveHotelsToDb (ArrayList<Hotel> hotels) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Games\\java\'Hotel.txt"))){
            bw.write(String.valueOf(hotels));
        } catch (IOException e) {
            System.err.println("Can`t save Hotels to BD");
        }
    }

    public Hotel getHotelById(Long id) throws Exception {
        checkAdmin();
        for (Hotel h : readHotelFromFile()) {
            if (h.getId() == id) {
                return h;
            }
        }
        throw new Exception("Can`t find Hotel whit ID " + id);
    }

    public Hotel findHotelByName(String name) throws Exception {
        for (Hotel h: readHotelFromFile()){
            if (h.getName().equals(name))
                return h;
        }
        throw new Exception("Can`t find Hotel whit name " + name);
    }



    public ArrayList<Hotel> readHotelFromFile() throws Exception {

        ArrayList<Hotel> hotels = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("E:\\Games\\java\'Hotel.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                hotelValidator(line);
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

    private void hotelValidator(String line) throws Exception {

        String[] text = line.split(",");

        if (text.length != 4) {
            throw new Exception("File User.txt broken. Collapse.");
        }

        if (text[1] == null) {
            throw new Exception("field Hotel name is empty. ID " + text[0]);
        }

        if (text[2] == null) {
            throw new Exception("field Country is empty. ID " + text[0]);
        }

        if (text[3] == null) {
            throw new Exception("field City is empty. ID " + text[0]);
        }

        if (text[4] == null) {
            throw new Exception("field Street is empty. ID " + text[0]);
        }
    }

    public void checkAdmin() throws Exception {
        if (start.getLoggedInUser().getType()!= UserType.ADMIN){
            throw new Exception ("User " + start.getLoggedInUser().getUserName() + " don`t have rights for this operation. Please contact the administrator");
        }
    }
}
