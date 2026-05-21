package com.rcs.user.service.repositories

import com.rcs.user.service.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String>