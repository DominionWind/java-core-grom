package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.servise.HotelService;

import java.util.ArrayList;

public class HotelController {
    private HotelService hotelService = new HotelService();

    public Hotel findHotelByName(String name) throws Exception {
        return hotelService.findHotelByName(name);
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        return hotelService.findHotelByCity(city);
    }

    public void addHotel (Hotel hotel) throws Exception {
        hotelService.addHotel(hotel);
    }

    public void deleteHotel(long hotelId) throws Exception {
        hotelService.deleteHotel(hotelId);
    }
}
