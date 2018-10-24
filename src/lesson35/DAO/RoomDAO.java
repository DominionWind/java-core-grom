package lesson35.DAO;

import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.io.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

public class RoomDAO {

    HotelDAO hotelDAO = new HotelDAO();

    public void addRoom(Room room) throws Exception {
        writeRoomToDB(room);
    }

    public void deleteRoom(long roomId) throws Exception {
        ArrayList<Room> rooms = readRoomFromFile();
        rooms.remove(getRoomById(roomId));
        saveRoomsToDb(rooms);
    }

    private void writeRoomToDB(Room room) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter("E:\\Games\\java\'Room.txt", true))) {
            br.newLine();
            br.write(room.toString());
        } catch (IOException e) {
            System.err.println("Can`t save Room with ID " + room.getId() + " to DB");
        }
    }

    public void saveRoomsToDb(ArrayList<Room> rooms) throws FileNotFoundException {
        deleteRoomsFromDB();
        for (Room r:rooms){
            writeRoomToDB(r);
        }
    }

    public ArrayList<Room> findRooms(Filter filter) {

        //todo
        return null;
    }

    public Room getRoomById(long id) throws Exception {
        for (Room r : readRoomFromFile()) {
            if (r.getId() == id) {
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
        LocalDate dateAvailableFrom = LocalDate.from(Instant.parse(mod[5]));
        Hotel hotel = hotelDAO.getHotelById(Long.parseLong(mod[6]));

        Room room = new Room(id, numberOfGuests, price, breakfastIncluded, petsAllowed, dateAvailableFrom, hotel);

        return room;
    }

    private void deleteRoomsFromDB() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("E:\\Games\\java\'Room.txt");
        writer.print("");
        writer.close();
    }

    private void setDate(Room room, LocalDate date){//todo
        room.setDateAvailableFrom(date);
    }
}
