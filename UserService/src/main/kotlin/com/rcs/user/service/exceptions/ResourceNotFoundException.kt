package com.rcs.user.service.exceptions

class ResourceNotFoundException : RuntimeException {
    constructor(message: String) : super(message)
    constructor() : super("Resource not found")
}