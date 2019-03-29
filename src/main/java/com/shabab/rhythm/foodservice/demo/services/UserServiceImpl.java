package com.shabab.rhythm.foodservice.demo.services;


import com.shabab.rhythm.foodservice.demo.models.User;
import com.shabab.rhythm.foodservice.demo.repositories.RoleRepository;
import com.shabab.rhythm.foodservice.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }
}
