package com.example.mongoApi

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

class APIResponse(
    message: String,
    status: HttpStatus,
    timestamp: LocalDateTime = LocalDateTime.now()
)