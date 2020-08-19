package com.rodrigol.hotel.controller

import com.rodrigol.hotel.dto.error.ErrorDTO
import com.rodrigol.hotel.exception.observation.ObservationNotExistException
import com.rodrigol.hotel.exception.reservation.ReservationNotAvailable
import com.rodrigol.hotel.exception.reservation.ReservationNotExistException
import com.rodrigol.hotel.exception.room.RoomNotExistException
import com.rodrigol.hotel.exception.user.UserAlreadyExistException
import com.rodrigol.hotel.exception.user.UserNotExistException
import io.jsonwebtoken.SignatureException
import org.springframework.http.HttpStatus
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class ControllerAdvice: ResponseEntityExceptionHandler() {

    /* Users exceptions */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserAlreadyExistException::class)
    fun handleUserAlreadyExistException(e: UserAlreadyExistException): ErrorDTO {
        return ErrorDTO(1000, "User dni already exists")
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsernameNotFoundException::class)
    fun handleUsernameNotFoundException(e: UsernameNotFoundException): ErrorDTO {
        return ErrorDTO(1001, "User DNI ${e.message} does not exist")
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotExistException::class)
    fun handleUserNotExistException(e: UserNotExistException): ErrorDTO {
        return ErrorDTO(1002, "User ID does not exist")
    }

    /* Reservations exceptions */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ReservationNotExistException::class)
    fun handleReservationNotExistException(e: ReservationNotExistException): ErrorDTO {
        return ErrorDTO(2001, "Reservation ID does not exist")
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ReservationNotAvailable::class)
    fun handleReservationNotAvailable(e: ReservationNotAvailable): ErrorDTO {
        return ErrorDTO(2002, "Reservation not available on selected dates and room")
    }

    /* Observations exceptions */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObservationNotExistException::class)
    fun handleObservationNotExistException(e: ObservationNotExistException): ErrorDTO {
        return ErrorDTO(3001, "Observation ID does not exist")
    }

    /* Rooms exceptions */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RoomNotExistException::class)
    fun handleRoomNotExistException(e: RoomNotExistException): ErrorDTO {
        return ErrorDTO(4001, "Room ID does not exist")
    }

    /* Auth exceptions */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(SignatureException::class)
    fun handleSignatureException(e: SignatureException): ErrorDTO {
        return ErrorDTO(5001, "JWT signature does not match")
    }

}