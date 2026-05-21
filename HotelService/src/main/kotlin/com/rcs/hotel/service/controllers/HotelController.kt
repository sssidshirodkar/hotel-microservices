package com.rcs.hotel.service.controllers

import com.rcs.hotel.service.entities.Hotel
import com.rcs.hotel.service.services.HotelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hotels")
class HotelController(
    @Autowired val service: HotelService
) {
    @PostMapping
    fun createHotel(@RequestBody hotel: Hotel): ResponseEntity<Hotel> {
        val createdUser = service.createHotel(hotel)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser)
    }

    @GetMapping("/{hotelId}")
    fun getHotelById(@PathVariable hotelId: String): ResponseEntity<Hotel> {
        val hotel = service.getHotelById(hotelId)
        return ResponseEntity.status(HttpStatus.OK).body(hotel)
    }

    @GetMapping
    fun getAllHotels(): ResponseEntity<List<Hotel>> {
        val hotels = service.getAllHotels()
        return ResponseEntity.status(HttpStatus.OK).body(hotels)
    }
}