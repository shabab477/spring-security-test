package com.shabab.rhythm.foodservice.demo.repositories;

import com.shabab.rhythm.foodservice.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
