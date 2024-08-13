package com.example.springBootDeneme.controllers;

import com.example.springBootDeneme.models.User;
import com.example.springBootDeneme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        try {
            userRepository.save(user);
        } catch (Exception ex) {
            return "Registration failed: " + ex.getMessage();
        }
        return "Successfully registered";
    }
}
