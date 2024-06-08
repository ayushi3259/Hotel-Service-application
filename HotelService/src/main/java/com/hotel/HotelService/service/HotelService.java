package com.hotel.HotelService.service;

import com.hotel.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel saveHotelDetails(Hotel hotel);

    Hotel updateHotelDetails(Hotel hotel, Integer hotelId);

    void deleteHotelDetails(Integer hotelId);

    Hotel getHotelDetailsById(Integer hotelId);

    List<Hotel> getAllHotelDetails();
}
