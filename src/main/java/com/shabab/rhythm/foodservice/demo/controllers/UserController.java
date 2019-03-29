package com.shabab.rhythm.foodservice.demo.controllers;

import com.shabab.rhythm.foodservice.demo.models.Role;
import com.shabab.rhythm.foodservice.demo.models.User;
import com.shabab.rhythm.foodservice.demo.repositories.CartRepository;
import com.shabab.rhythm.foodservice.demo.repositories.FoodRepository;
import com.shabab.rhythm.foodservice.demo.services.SecurityService;
import com.shabab.rhythm.foodservice.demo.services.UserService;
import com.shabab.rhythm.foodservice.demo.utils.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sun.net.httpserver.AuthFilter;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @GetMapping("/admin")
    public String showAdminPage(Model model) {
        model.addAttribute("foods", foodRepository.findAll());

        return "admin";
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        String password = userForm.getPassword();
        userService.save(getDefaultRegisteredUser(userForm));

        securityService.autoLogin(userForm.getUserName(), password);

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String showCustomerLogin(Model model, String error, String logout) {
        model.addAttribute("userForm", new User());

        return "login";
    }

    @GetMapping("/login-admin")
    public String showAdminLogin(Model model, String error, String logout) {
        model.addAttribute("userForm", new User());

        return "login-admin";
    }

    @PostMapping("/postLogin")
    public String postLogin(Model model, HttpSession session) {
        org.springframework.security.core.userdetails.User loggedInUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("currentUser", loggedInUser.getUsername());

        session.setAttribute("userId", loggedInUser.getUsername());
        if (loggedInUser.getAuthorities().size() > 0 && loggedInUser.getAuthorities().iterator().next().getAuthority().equals("ROLE_ADMIN")) {
            return "redirect:/admin";
        }

        return "redirect:/welcome";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        model.addAttribute("isLoggedIn", AuthUtils.isLoggedIn());
        model.addAttribute("foods", foodRepository.findAll());
        model.addAttribute(
                "cart",
                AuthUtils.isLoggedIn()?
                        cartRepository
                                .findByUserId(
                                        userService
                                                .findByUserName(AuthUtils
                                                        .getLoggedInUser().getUsername())
                                                .getId()
                                ) : null
        );

        return "welcome";
    }

    private User getDefaultRegisteredUser(User user) {
        Role role = new Role();
        role.setName("ROLE_CUSTOMER");

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);

        return user;
    }
}
