package com.user.service.UserService.VO;

import com.user.service.UserService.entities.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingResponseVO {
    List<Rating> ratingList = new ArrayList<>();
}
