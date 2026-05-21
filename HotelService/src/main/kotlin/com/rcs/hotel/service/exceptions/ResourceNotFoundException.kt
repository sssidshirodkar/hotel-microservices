package com.rcs.hotel.service.exceptions

class ResourceNotFoundException : RuntimeException {
    constructor(message: String) : super(message)
    constructor() : super("Resource not found")
}