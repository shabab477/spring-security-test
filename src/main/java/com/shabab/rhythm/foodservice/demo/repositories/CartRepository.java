package com.shabab.rhythm.foodservice.demo.repositories;

import com.shabab.rhythm.foodservice.demo.models.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Long> {
    public List<Cart> findByUserId(Long id);
}
