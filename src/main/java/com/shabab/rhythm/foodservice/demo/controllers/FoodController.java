package com.shabab.rhythm.foodservice.demo.controllers;

import java.util.List;

import com.shabab.rhythm.foodservice.demo.models.Cart;
import com.shabab.rhythm.foodservice.demo.models.Food;
import com.shabab.rhythm.foodservice.demo.models.Restaurant;
import com.shabab.rhythm.foodservice.demo.repositories.CartRepository;
import com.shabab.rhythm.foodservice.demo.repositories.FoodRepository;
import com.shabab.rhythm.foodservice.demo.repositories.UserRepository;
import com.shabab.rhythm.foodservice.demo.services.FoodService;
import com.shabab.rhythm.foodservice.demo.utils.AuthUtils;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Controller
public class FoodController {

    @Autowired
    private FoodService rs;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private CartRepository cartRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/admin/food")
    public String saveFood(Food food) {
        foodRepository.save(food);

        return "redirect:/admin";
    }

    @PostMapping(value = "admin/food/delete")
    public String deleteFoodItem(Food food) {
        foodRepository.delete(foodRepository.findById(food.getId()).get());

        return "redirect:/admin";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/food/cart")
    public String addToCart(Food food) {
        Cart cart = new Cart();
        cart.setFood(rs.getFood(food.getId()));
        cart.setUser(userRepository.findByUserName(AuthUtils.getLoggedInUser().getUsername()));
        cartRepository.save(cart);

        return "redirect:/welcome";
    }

}