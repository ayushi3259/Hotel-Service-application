package com.user.service.UserService.entities;

import lombok.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Rating {

    private Integer ratingId;

    private Integer userId;

    private Integer hotelId;

    private Integer rating;

    private String feedback;

    private Hotel hotel;

}
