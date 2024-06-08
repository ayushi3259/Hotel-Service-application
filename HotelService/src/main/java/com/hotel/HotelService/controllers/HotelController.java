package com.hotel.HotelService.controllers;


import com.hotel.HotelService.entities.Hotel;
import com.hotel.HotelService.exceptions.ApiResponse;
import com.hotel.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;


    @PostMapping("/save")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = this.hotelService.saveHotelDetails(hotel);
        return new ResponseEntity(hotel1, HttpStatus.CREATED);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Integer id){
        Hotel hotelDetailsById = this.hotelService.getHotelDetailsById(id);

        return new ResponseEntity<>(hotelDetailsById,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel,@PathVariable Integer id){
        Hotel hotel1 = this.hotelService.updateHotelDetails(hotel, id);
        return new ResponseEntity<Hotel>(hotel1,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteHotel(@PathVariable Integer id){
        this.hotelService.deleteHotelDetails(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("deleted",true,HttpStatus.OK),HttpStatus.OK);
    }
}
