package gromcode.main.lesson15.HomeWork.UserRepository.API;

public class BookingComAPI implements API {

    Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (Room room : rooms) {
            if (room != null && price >= room.getPrice() - 100 && price <= room.getPrice()+100&& persons == room.getPersons()&&city == room.getCityName()&&hotel==room.getHotelName()){
                count ++;
            }
        }

        Room[]rightRoom = new Room[count];
        int i=0;
        for (Room room:rooms){
            if (room != null && price >= room.getPrice() - 100 && price <= room.getPrice()+100&& persons == room.getPersons()&&city == room.getCityName()&&hotel==room.getHotelName()){
                rightRoom[i]=room;
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
