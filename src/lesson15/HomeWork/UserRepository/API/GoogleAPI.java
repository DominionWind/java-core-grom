package lesson15.HomeWork.UserRepository.API;

public class GoogleAPI implements API {

    Room[]rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (Room room : rooms) {
            if (room != null && price == room.getPrice() && persons == room.getPersons() && city.equals(room.getCityName()) && hotel.equals(room.getHotelName())) {
                count++;
            }
        }

        Room[] rightRoom = new Room[count];
        int i = 0;
        for (Room room : rooms) {
            if (room != null && price == room.getPrice() && persons == room.getPersons() && city.equals(room.getCityName()) && hotel.equals(room.getHotelName())) {
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
