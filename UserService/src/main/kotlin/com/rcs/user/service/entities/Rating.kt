package com.rcs.user.service.entities

data class Rating(
    val ratingId: String,
    val userId: String,
    val hotelId: String,
    val rating: Int,
    val feedback: String,
    var hotel: Hotel? = null,
)