package gromcode.main.lesson15.HomeWork.UserRepository.API;

public interface API {

    Room[] findRooms(int price, int persons, String city, String hotel);

    Room[] getAll();
}
