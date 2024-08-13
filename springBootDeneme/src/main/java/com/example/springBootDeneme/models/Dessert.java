package com.example.springBootDeneme.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "desserts")
public class Dessert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private double rating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
