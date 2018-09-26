package lesson35.DAO;

import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class RoomDAO {

    HotelDAO hotelDAO = new HotelDAO();

    public Room registerRoom(Room room) throws Exception {
        ArrayList<Room> rooms = readRoomFromFile();
        rooms.add(room);
        saveRoomToDb(rooms);
        return room;
    }

    public void saveRoomToDb(ArrayList<Room> rooms){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Games\\java\'Room.txt"))){
            bw.write(String.valueOf(rooms));
        } catch (IOException e){
        System.err.println("Can`t save Rooms to BD");
        }
    }

    public ArrayList<Room> findRooms(Filter filter){

        //todo
        return null;
    }

    public Room getRoomById(long id) throws Exception {
        for (Room r:readRoomFromFile()){
            if (r.getId()==id){
                return r;
            }
        }
        throw new Exception("Can`t find Room whit ID " + id);
    }

    public ArrayList<Room> readRoomFromFile() throws Exception {

        ArrayList<Room> rooms = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("E:\\Games\\java\'Room.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                roomValidator(line);
                rooms.add(stringToRoomConvector(line));
            }
        } catch (IOException e) {
            System.err.println("Reading from file E:\\Games\\java\\Room.txt failed");
        }

        return rooms;
    }

    private Room stringToRoomConvector(String string) throws Exception {

        String[] mod = string.split(",");

        long id = Long.parseLong(mod[0]);
        int numberOfGuests = Integer.parseInt(mod[1]);
        double price = Double.parseDouble(mod[2]);
        boolean breakfastIncluded = Boolean.parseBoolean(mod[3]);
        boolean petsAllowed = Boolean.parseBoolean(mod[4]);
        Date dateAvailableFrom = Date.from(Instant.parse(mod[5]));
        Hotel hotel = hotelDAO.getHotelById(Long.parseLong(mod[6]));

        Room room = new Room(id, numberOfGuests, price, breakfastIncluded, petsAllowed, dateAvailableFrom, hotel);

        return room;
    }

    private void roomValidator(String line) throws Exception {

        String[] text = line.split(",");

        if (text.length != 6) {
            throw new Exception("File Room.txt broken. Collapse.");
        }

        if (text[1] == null) {
            throw new Exception("field numberOfGuests name is empty. ID " + text[0]);
        }

        if (text[2] == null) {
            throw new Exception("field price is empty. ID " + text[0]);
        }

        if (text[3] == null) {
            throw new Exception("field breakfastIncluded is empty. ID " + text[0]);
        }

        if (text[4] == null) {
            throw new Exception("field petsAllowed is empty. ID " + text[0]);
        }

        if (text[5] == null) {
            throw new Exception("field dateAvailableFrom is empty. ID " + text[0]);
        }

        if (text[6] == null) {
            throw new Exception("field Hotel is empty. ID " + text[0]);
        }
    }
}
