package com.shabab.rhythm.foodservice.demo.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUtils {

    public static boolean isLoggedIn() {
        Object details = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return details instanceof UserDetails;
    }

    public static User getLoggedInUser() {
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser == null) {
            return null;
        }

        return (User) loggedInUser;
    }
}
