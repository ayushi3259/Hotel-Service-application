package com.user.service.UserService.service;

import com.user.service.UserService.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUserById(Integer id);

    User updateUser(User user,Integer id);

    void deleteUser(Integer id);

}
