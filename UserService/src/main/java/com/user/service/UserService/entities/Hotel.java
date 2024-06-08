package com.user.service.UserService.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private Integer hotelId;
    private String hotelName;
    private String hotelLocation;

    private String about;
}
