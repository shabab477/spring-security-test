package com.shabab.rhythm.foodservice.demo.services;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
