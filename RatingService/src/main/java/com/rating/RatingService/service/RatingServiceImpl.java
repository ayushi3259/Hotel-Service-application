package com.rating.RatingService.service;

import com.rating.RatingService.entities.Rating;
import com.rating.RatingService.repository.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepo ratingRepo;
    @Override
    public Rating createRating(Rating rating) {
        Rating save = this.ratingRepo.save(rating);
        return save;
    }

    @Override
    public List<Rating> getAllRatings() {
        List<Rating> allRatings = this.ratingRepo.findAll();
        return allRatings;
    }

    @Override
    public List<Rating> getRatingByUserId(Integer userId) {

        List<Rating> byUserId = this.ratingRepo.findByUserId(userId);
        return byUserId;
    }

    @Override
    public List<Rating> getRatingByHotelId(Integer hotelId) {
        List<Rating> byHotelId = this.ratingRepo.findByHotelId(hotelId);
        return byHotelId;
    }
}
