package com.rodrigol.hotel.controller

import com.rodrigol.hotel.dto.ErrorDto
import com.rodrigol.hotel.exception.user.UserAlreadyExistException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@RestControllerAdvice
class ControllerAdvice: ResponseEntityExceptionHandler() {

    /* Users exceptions */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserAlreadyExistException::class)
    fun handleUserAlreadyExistException(e: UserAlreadyExistException): ErrorDto {
        return ErrorDto(1, "User dni name already exists")
    }

}