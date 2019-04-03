package com.shabab.rhythm.foodservice.demo.controllers;

import com.shabab.rhythm.foodservice.demo.models.Cart;
import com.shabab.rhythm.foodservice.demo.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping(value = "/cart/remove")
    public String removeFromCart(Cart cart) {
        if (cartRepository.findById(cart.getId()).isPresent()) {
            cartRepository.delete(cartRepository.findById(cart.getId()).get());
        }

        return "redirect:/welcome";
    }
}
