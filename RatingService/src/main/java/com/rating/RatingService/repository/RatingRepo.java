package com.rating.RatingService.repository;

import com.rating.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Rating,Integer> {

    List<Rating> findByHotelId(Integer hotelId);

    List<Rating> findByUserId(Integer userId);

}
