package com.rcs.rating.service.service;

import com.rcs.rating.service.entities.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
    List<Rating> getAllRatings();
    List<Rating> getAllRatingsByUser(String userId);
    List<Rating> getAllRatingsByHotel(String hotelId);
}
