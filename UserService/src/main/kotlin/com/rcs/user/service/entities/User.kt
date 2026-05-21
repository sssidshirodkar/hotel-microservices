package com.rcs.user.service.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Getter

@Entity
@Table(name = "micro_users")
@Getter
data class User(
    @Id
    @Column(name = "id")
    var userId: String? = null,

    @Column(name = "name", length = 50)
    var name: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "about")
    var about: String,

    @Transient
    private var _ratings: List<Rating>? = emptyList(),
){
    val ratings: List<Rating>
        get() = _ratings ?: emptyList()

    fun setRatings(ratings: List<Rating>?) {
        this._ratings = ratings ?: emptyList()
    }
}