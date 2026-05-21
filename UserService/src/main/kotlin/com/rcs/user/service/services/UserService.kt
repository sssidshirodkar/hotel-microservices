package com.rcs.user.service.services

import com.rcs.user.service.entities.User

interface UserService {
    fun saveUser(user: User): User
    fun findUserById(userId: String): User
    fun getUsers(): List<User>
}