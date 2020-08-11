package com.rodrigol.hotel.controller

import com.rodrigol.hotel.dto.ErrorDto
import com.rodrigol.hotel.exception.reservation.ReservationNotAvailable
import com.rodrigol.hotel.exception.reservation.ReservationNotExistException
import com.rodrigol.hotel.exception.user.UserAlreadyExistException
import com.rodrigol.hotel.exception.user.UserNotExistException
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotExistException::class)
    fun handleUserNotExistException(e: UserNotExistException): ErrorDto {
        return ErrorDto(2, "User ID not exist")
    }

    /* Reservations exceptions */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ReservationNotExistException::class)
    fun handleReservationNotExistException(e: ReservationNotExistException): ErrorDto {
        return ErrorDto(3, "Reservation ID not exist")
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ReservationNotAvailable::class)
    fun handleReservationNotAvailable(e: ReservationNotAvailable): ErrorDto {
        return ErrorDto(4, "Reservation not available on selected dates and room")
    }

}