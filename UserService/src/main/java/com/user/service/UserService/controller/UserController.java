package com.user.service.UserService.controller;

import com.user.service.UserService.entities.User;
import com.user.service.UserService.payload.ApiResponse;
import com.user.service.UserService.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    private Logger logger=  LoggerFactory.getLogger(UserController.class);

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User user1 = this.userService.saveUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAlluser(){
        List<User> allUser = this.userService.getAllUser();
        return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
    }

    @GetMapping("/getUserById/{id}")
  //  @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name="userRateLimiter",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        System.out.println("api");
        User userById = this.userService.getUserById(id);
        return new ResponseEntity<User>(userById, HttpStatus.OK);
    }

    //ratingHotelFallback method for circuit breaker
    public ResponseEntity<User> ratingHotelFallback(Integer id,Exception e){
        logger.info("The fallback is executed because the service is down: {}", e.getMessage());
        User dummy = User.builder()
                .userName("dummy")
                .email("dummy@xyz.com")
                .about("dummy user created as some service is down").id(3323)
                .build();
        return new ResponseEntity<>(dummy,HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id){
        User userById = this.userService.updateUser(user,id);
        return new ResponseEntity<User>(userById, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id){
        this.userService.deleteUser(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("deleted",true,HttpStatus.OK), HttpStatus.OK);
    }



}
