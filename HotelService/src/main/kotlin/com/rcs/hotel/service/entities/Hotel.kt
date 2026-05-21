package com.rcs.hotel.service.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "hotels")
data class Hotel(
    @Id
    var id: String? = null,
    var name: String,
    var location: String,
    var about: String,
)