package lesson35.DAO;

import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.io.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

public class RoomDAO {

    DAO<Room> dao = new DAO<Room>() {
        @Override
        public Room convector(String string) throws Exception {
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
    };

    HotelDAO hotelDAO = new HotelDAO();

    private static String path = "E:\\Games\\java\\Room.txt";

    public void addRoom(Room room) throws Exception {
        writeRoomToDB(room);
    }

    public void deleteRoom(long roomId) throws Exception {
        ArrayList<Room> rooms = readRoomFromFile();
        rooms.remove(getRoomById(roomId));
        saveRoomsToDb(rooms);
    }

    private void writeRoomToDB(Room room) {
        dao.writerToFile(room, path);
    }

    public void saveRoomsToDb(ArrayList<Room> rooms) throws FileNotFoundException {
        deleteRoomsFromDB();
        for (Room r : rooms) {
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
        return dao.readFromFile(path);
    }

    private void deleteRoomsFromDB() throws FileNotFoundException {
        dao.deleteContent(path);
    }

    private void setDate(Room room, LocalDate date) {//todo
        room.setDateAvailableFrom(date);
    }
}
