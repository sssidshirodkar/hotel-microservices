package com.rcs.user.service.services.impl

import com.rcs.user.service.entities.Rating
import com.rcs.user.service.entities.User
import com.rcs.user.service.exceptions.ResourceNotFoundException
import com.rcs.user.service.external.service.HotelService
import com.rcs.user.service.repositories.UserRepository
import com.rcs.user.service.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.*

@Service
class UserServiceImpl(
    @Autowired val repository: UserRepository,
    @Autowired val restTemplate: RestTemplate,
    @Autowired val hotelService: HotelService,
) : UserService {
    override fun saveUser(user: User): User {
        val randomId = UUID.randomUUID()
        user.userId = randomId.toString()
        return repository.save(user)
    }

    override fun findUserById(userId: String): User {
        val user = repository.findById(userId).orElseThrow { ResourceNotFoundException("Resource not found for id: $userId") }

        val response: ResponseEntity<List<Rating>> = restTemplate.exchange(
            "http://RATING-SERVICE/ratings/users/${user.userId}",
            HttpMethod.GET,
            null,
            object : ParameterizedTypeReference<List<Rating>>() {}
        )
        val ratings = response.body ?: emptyList()

        ratings.forEach { rating ->
            val hotel = hotelService.getHotelById(rating.hotelId)
            rating.hotel = hotel
        }

        user.setRatings(ratings)
        return user
    }

    override fun getUsers(): List<User> {
        return repository.findAll()
    }
}