package com.rcs.rating.service.service.impl;

import com.rcs.rating.service.entities.Rating;
import com.rcs.rating.service.repositories.RatingRepository;
import com.rcs.rating.service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository repository;

    @Override
    public Rating createRating(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getAllRatingsByUser(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingsByHotel(String hotelId) {
        return repository.findByHotelId(hotelId);
    }
}
