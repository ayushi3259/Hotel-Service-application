package com.hotel.HotelService.exceptions;

import org.springframework.http.ResponseEntity;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(){
        super("Resource not found on server");
    }
    public ResourceNotFoundException(String messgae){
        super(messgae);
    }
}
