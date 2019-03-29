package com.shabab.rhythm.foodservice.demo.services;


import com.shabab.rhythm.foodservice.demo.models.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
