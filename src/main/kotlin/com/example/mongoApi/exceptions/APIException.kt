package com.example.mongoApi.exceptions

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

class APIException(
    var message: String,
    var status: HttpStatus,
    var timestamp: LocalDateTime = LocalDateTime.now()
)