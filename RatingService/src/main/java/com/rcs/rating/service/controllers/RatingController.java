package com.rcs.rating.service.controllers;

import com.rcs.rating.service.entities.Rating;
import com.rcs.rating.service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    RatingService service;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating newRating = service.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRating);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.ok(service.getAllRatings());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUser(@PathVariable String userId){
        return ResponseEntity.ok(service.getAllRatingsByUser(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingsByHotel(@PathVariable String hotelId){
        return ResponseEntity.ok(service.getAllRatingsByHotel(hotelId));
    }
}
