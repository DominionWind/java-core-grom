package lesson11.HomeWork;

public class BookingComAPI implements API {

    Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (Room room : rooms) {
            if (room != null && (price + 100) >= room.getPrice() && (price - 100) <= room.getPrice() && persons == room.getPersons() && city == room.getCityName() && hotel == room.getHotelName()) {
                count++;
            }
        }

        Room[] rightRoom = new Room[count];
        int i = 0;
        for (Room room : rooms) {
            if (room != null && (price + 100) >= room.getPrice() && (price - 100) <= room.getPrice() && persons == room.getPersons() && city == room.getCityName() && hotel == room.getHotelName()) {
                rightRoom[i] = room;
                i++;
            }
        }
        return rightRoom;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
