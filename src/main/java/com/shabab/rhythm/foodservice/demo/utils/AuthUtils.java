package com.shabab.rhythm.foodservice.demo.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUtils {

    public static boolean isLoggedIn() {
        Object details = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return details instanceof UserDetails;
    }
}
