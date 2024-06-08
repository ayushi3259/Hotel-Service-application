package com.rating.RatingService.controller;


import com.rating.RatingService.entities.Rating;
import com.rating.RatingService.service.RatingService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/save")
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Rating>> getALlRating(){
        List<Rating> allRatings = ratingService.getAllRatings();
        return new ResponseEntity<List<Rating>>(allRatings,HttpStatus.OK);
    }

    @GetMapping("/getByUser/{id}")
    public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable Integer id){
        return ResponseEntity.ok(ratingService.getRatingByUserId(id));
    }

    @GetMapping("/getByHotel/{id}")
    public ResponseEntity<List<Rating>> getRatingByHotel(@PathVariable Integer id){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(id));
    }


}
