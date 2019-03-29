package com.shabab.rhythm.foodservice.demo.controllers;

import java.util.List;

import com.shabab.rhythm.foodservice.demo.models.Cart;
import com.shabab.rhythm.foodservice.demo.models.Food;
import com.shabab.rhythm.foodservice.demo.models.Restaurant;
import com.shabab.rhythm.foodservice.demo.repositories.CartRepository;
import com.shabab.rhythm.foodservice.demo.repositories.UserRepository;
import com.shabab.rhythm.foodservice.demo.services.FoodService;
import com.shabab.rhythm.foodservice.demo.utils.AuthUtils;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FoodController {

    @Autowired
    private FoodService rs;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @RequestMapping("/restaurant/{id}/food")
    public List<Food> getallFood(@PathVariable String id) {
        return rs.getAllFood(id);
    }

    @RequestMapping("/restaurant/{resid}/food/{id}")
    public Food getFood(@PathVariable String id) {

        return rs.getFood(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/admin/restaurant/{resid}/food/{id}")
    public void delFood(@PathVariable String id) {
        rs.delFood(id);
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