package com.rcs.hotel.service.payload

import lombok.*
import org.springframework.http.HttpStatus

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
data class ApiResponse(
    val message: String,
    val success: Boolean,
    val status: HttpStatus,
)