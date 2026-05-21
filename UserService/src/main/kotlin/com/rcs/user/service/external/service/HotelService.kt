package com.rcs.user.service.external.service

import com.rcs.user.service.entities.Hotel
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "HOTEL-SERVICE")
interface HotelService {
    @GetMapping("/hotels/{hotelId}")
    fun getHotelById(@PathVariable hotelId: String): Hotel
}