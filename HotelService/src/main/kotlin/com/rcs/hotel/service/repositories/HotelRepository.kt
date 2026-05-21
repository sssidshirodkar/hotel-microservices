package com.rcs.hotel.service.repositories

import com.rcs.hotel.service.entities.Hotel
import org.springframework.data.jpa.repository.JpaRepository

interface HotelRepository :  JpaRepository<Hotel, String>