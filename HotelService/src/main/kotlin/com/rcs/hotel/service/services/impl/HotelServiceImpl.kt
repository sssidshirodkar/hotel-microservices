package com.rcs.hotel.service.services.impl

import com.rcs.hotel.service.entities.Hotel
import com.rcs.hotel.service.exceptions.ResourceNotFoundException
import com.rcs.hotel.service.repositories.HotelRepository
import com.rcs.hotel.service.services.HotelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class HotelServiceImpl(@Autowired val repository: HotelRepository): HotelService {
    override fun createHotel(hotel: Hotel): Hotel {
        val randomId = UUID.randomUUID()
        hotel.id = randomId.toString()
        return repository.save(hotel);
    }

    override fun getAllHotels(): List<Hotel> {
        return repository.findAll()
    }

    override fun getHotelById(id: String): Hotel {
        return repository.findById(id).orElseThrow{ ResourceNotFoundException("Hotel with ID $id not found") }
    }
}