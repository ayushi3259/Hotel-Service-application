package com.user.service.UserService.service;

import com.user.service.UserService.UserRepo;
import com.user.service.UserService.entities.Hotel;
import com.user.service.UserService.entities.Rating;
import com.user.service.UserService.entities.User;
import com.user.service.UserService.exceptions.ResourceNotFoundException;
import com.user.service.UserService.externalService.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger= LoggerFactory.getLogger(UserService.class);




    @Autowired
    private UserRepo userRepo;
    @Override
    public User saveUser(User user) {
        User save = this.userRepo.save(user);
        return save;
    }

    @Override
    public List<User> getAllUser() {
        List<User> listAll = this.userRepo.findAll();
//        ParameterizedTypeReference<List<Rating>> rating = new ParameterizedTypeReference<List<Rating>>() {};
        listAll.forEach(user->{
            ParameterizedTypeReference<List<Rating>> rating = new ParameterizedTypeReference<List<Rating>>() {};
            ResponseEntity<List<Rating>> forEntity = restTemplate.exchange("http://RATING-SERVICE/rating/getByUser/" + user.getId(), HttpMethod.GET,null ,rating);
            List<Rating> eachRating = forEntity.getBody();
            eachRating.forEach(val->{
                Hotel hotel = hotelService.getHotel(val.getHotelId());
                val.setHotel(hotel);
            });
            user.setRatings(eachRating);
        });

        return listAll;
    }

    @Override
    public User getUserById(Integer id) {
        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server"));
        ParameterizedTypeReference<List<Rating>> rating = new ParameterizedTypeReference<List<Rating>>() {};
        ResponseEntity<List<Rating>> response = restTemplate.exchange("http://RATING-SERVICE/rating/getByUser/"+user.getId(), HttpMethod.GET, new HttpEntity<>(null),rating);
        assert response.getBody() != null;
        List<Rating> rating1=response.getBody();
                rating1.forEach(val -> {
                   // ResponseEntity<Hotel> exchange = restTemplate.exchange("http://HOTEL-SERVICE/hotel/get/" + val.getRatingId(), HttpMethod.GET, new HttpEntity<>(null), Hotel.class);
                    //Hotel body = exchange.getBody();
                    Hotel hotel= hotelService.getHotel(val.getHotelId());
                    val.setHotel(hotel);

        });

        user.setRatings(response.getBody());
        return user;
    }

    @Override
    public User updateUser(User user, Integer id) {
        Optional<User> existing = this.userRepo.findById(id);
        if(existing.isPresent()) {
            User updatedUser = existing.get();
            updatedUser.setUserName(user.getUserName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setAbout(user.getAbout());

            return this.userRepo.save(updatedUser);
        }
        return null;

    }

    @Override
    public void deleteUser(Integer id) {
        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server"));
        this.userRepo.deleteById(id);
    }
}
