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

        return new Room[0];
    }

    @Override
    public Room[] getAll() {
        return new Room[0];
    }
}
