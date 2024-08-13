package com.example.springBootDeneme.controllers;

import com.example.springBootDeneme.models.Dessert;
import com.example.springBootDeneme.models.User;
import com.example.springBootDeneme.repository.DessertRepository;
import com.example.springBootDeneme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/desserts")
public class DessertController {

    @Autowired
    private DessertRepository dessertRepository;

    @Autowired
    private UserRepository userRepository;

    // Create a new Dessert
    @PostMapping
    public ResponseEntity<Dessert> createDessert(@RequestBody Dessert dessert, @RequestParam Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            dessert.setUser(userOptional.get());
            Dessert newDessert = dessertRepository.save(dessert);
            return new ResponseEntity<>(newDessert, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
