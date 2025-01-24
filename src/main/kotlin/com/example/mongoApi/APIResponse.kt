package com.example.mongoApi

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

class APIResponse(
    val message: String,
    val status: Int,
    val timestamp: LocalDateTime = LocalDateTime.now()
)