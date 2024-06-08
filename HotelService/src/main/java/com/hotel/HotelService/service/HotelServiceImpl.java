package com.hotel.HotelService.service;

import com.hotel.HotelService.Repository.HotelRepo;
import com.hotel.HotelService.entities.Hotel;
import com.hotel.HotelService.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepo hotelRepo;
    @Override
    public Hotel saveHotelDetails(Hotel hotel) {
        Hotel save = this.hotelRepo.save(hotel);
        return save;
    }

    @Override
    public Hotel updateHotelDetails(Hotel hotel, Integer hotelId) {
        Hotel hotel1 = this.hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("id not found"));
        hotel1.setHotelName(hotel.getHotelName());
        hotel1.setHotelLocation(hotel1.getHotelLocation());
        hotel1.setAbout(hotel.getAbout());

        return hotel1;
    }

    @Override
    public void deleteHotelDetails(Integer hotelId) {
        Hotel hotel1 = this.hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("id not found"));
        this.hotelRepo.deleteById(hotelId);

    }

    @Override
    public Hotel getHotelDetailsById(Integer hotelId) {
        Hotel hotel1 = this.hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("id not found"));

        return hotel1;
    }

    @Override
    public List<Hotel> getAllHotelDetails() {
        List<Hotel> all = this.hotelRepo.findAll();
        return all;
    }
}
