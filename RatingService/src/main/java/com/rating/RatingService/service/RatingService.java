package com.rating.RatingService.service;

import com.rating.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {


    Rating createRating(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getRatingByUserId(Integer userId);

    List<Rating> getRatingByHotelId(Integer hotelId);



}
