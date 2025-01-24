package com.example.mongoApi.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(value = [ElementNotFoundException::class])
    fun handleElementNotFoundException(e: ElementNotFoundException): ResponseEntity<APIException> {
        val exception = APIException(e.message, HttpStatus.BAD_REQUEST,)

        return ResponseEntity(exception, HttpStatus.BAD_REQUEST)
    }
}