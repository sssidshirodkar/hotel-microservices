package com.rcs.user.service.controllers

import com.rcs.user.service.entities.User
import com.rcs.user.service.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    @Autowired val service: UserService
) {
    @PostMapping
    fun saveUser(@RequestBody user: User): ResponseEntity<User> {
        val createdUser = service.saveUser(user)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser)
    }

    @GetMapping("/{userId}")
    fun getUserById(@PathVariable userId: String): ResponseEntity<User> {
        val user = service.findUserById(userId)
        return ResponseEntity.status(HttpStatus.OK).body(user)
    }

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>> {
        val users = service.getUsers()
        return ResponseEntity.status(HttpStatus.OK).body(users)
    }
}