package lesson11.HomeWork;

public class Controller {
    API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    Room[] requestRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (API api : apis) {
            for (Room room : api.getAll()) {
                if (room != null && price == room.getPrice() && persons == room.getPersons() && city == room.getCityName() && hotel == room.getHotelName())
                    count++;
            }
        }
        Room[] rightRoom = new Room[count];
        int i = 0;
        for (API api : apis) {
            for (Room room : api.getAll()) {
                if (room != null && price == room.getPrice() && persons == room.getPersons() && city == room.getCityName() && hotel == room.getHotelName())
                    rightRoom[i] = room;
                i++;
            }
        }
        return rightRoom;
    }

    Room[] check(API api1, API api2) {
        int count = 0;

        for (Room room1 : api1.getAll()) {
            for (Room room2 : api2.getAll()) {
                if (room1 != null && room2 != null && room1.getPrice() == room2.getPrice() && room1.getPersons() == room2.getPersons() && room1.getCityName() == room2.getCityName() && room1.getHotelName() == room2.getHotelName()) {
                    count++;
                }
            }
        }
        Room[] rightRoom = new Room[count];
        int i = 0;
        for (Room room1 : api1.getAll()) {
            for (Room room2 : api2.getAll()) {
                if (room1 != null && room2 != null && room1.getPrice() == room2.getPrice() && room1.getPersons() == room2.getPersons() && room1.getCityName() == room2.getCityName() && room1.getHotelName() == room2.getHotelName()) {
                    rightRoom[i] = room1;
                    i++;
                }
            }
        }
        return rightRoom;
    }
}
