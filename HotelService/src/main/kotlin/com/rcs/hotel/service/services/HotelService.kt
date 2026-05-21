package com.rcs.hotel.service.services

import com.rcs.hotel.service.entities.Hotel

interface HotelService {
    fun createHotel(hotel: Hotel): Hotel
    fun getAllHotels(): List<Hotel>
    fun getHotelById(id: String): Hotel
}