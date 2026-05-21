package com.rcs.user.service.exceptions

import com.rcs.user.service.payload.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(e: ResourceNotFoundException): ResponseEntity<ApiResponse> {

        val response = ApiResponse(
            message = e.message ?: "Resource not found",
            success = true,
            status = HttpStatus.NOT_FOUND
        )
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }
}