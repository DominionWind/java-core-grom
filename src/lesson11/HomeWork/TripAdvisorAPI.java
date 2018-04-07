package lesson11.HomeWork;

public class TripAdvisorAPI implements API {

    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (Room room : rooms) {
            if (room != null && price == room.getPrice() && (persons + 1) >= room.getPersons() && (persons - 1) <= room.getPersons() && city == room.getCityName() && hotel == room.getHotelName()) {
                count++;
            }
        }

        Room[] rightRoom = new Room[count];
        int i = 0;
        for (Room room : rooms) {
            if (room != null && price == room.getPrice() && (persons + 1) >= room.getPersons() && (persons - 1) <= room.getPersons() && city == room.getCityName() && hotel == room.getHotelName()) {
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
