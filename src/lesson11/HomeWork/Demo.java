package lesson11.HomeWork;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Room room1 = new Room(111, 111, 1, new Date(), "11111", "11111");
        Room room2 = new Room(222, 222, 2, new Date(), "22222", "22222");
        Room room3 = new Room(333, 333, 3, new Date(), "33333", "33333");
        Room room4 = new Room(444, 111, 1, new Date(), "11111", "33333");
        Room room5 = new Room(111, 111, 1, new Date(), "11111", "11111");

        Room[] rooms = {room1, room2, room3, room4, room5, null, null, null, null, null};

        Room apartment1 = new Room(111, 111, 1, new Date(), "11111", "11111");
        Room apartment2 = new Room(222, 222, 2, new Date(), "22222", "22222");
        Room apartment3 = new Room(333, 333, 3, new Date(), "33333", "33333");
        Room apartment4 = new Room(546, 654, 1, new Date(), "11111", "11111");
        Room apartment5 = new Room(111, 73257, 1, new Date(), "11111", "11111");

        Room[] apartments = {apartment1, apartment2, apartment3, apartment4, apartment5, null, null, null};

        GoogleAPI googleAPI = new GoogleAPI(rooms);
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(apartments);
        BookingComAPI bookingComAPI = new BookingComAPI(rooms);

        API[] apis = new API[10];
        apis[1] = googleAPI;
        apis[2] = bookingComAPI;
        Controller controller = new Controller(apis);
        System.out.println("Test started");
        System.out.println("-------------------");
        System.out.println(Arrays.deepToString(googleAPI.getAll())+" Google API");
        System.out.println(Arrays.deepToString(bookingComAPI.getAll())+ " Booking API");
        System.out.println(Arrays.deepToString(googleAPI.findRooms(222, 2, "22222", "22222")));
        System.out.println();
        System.out.println(Arrays.deepToString(controller.check(googleAPI, bookingComAPI)));



    }
}
