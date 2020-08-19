package com.rodrigol.hotel.service

import com.rodrigol.hotel.exception.reservation.ReservationNotAvailable
import com.rodrigol.hotel.exception.reservation.ReservationNotExistException
import com.rodrigol.hotel.exception.user.UserNotExistException
import com.rodrigol.hotel.model.Reservation
import com.rodrigol.hotel.model.Room
import com.rodrigol.hotel.repository.ReservationRepository
import com.rodrigol.hotel.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ReservationService(
        private val reservationRepository: ReservationRepository,
        private val userRepository: UserRepository
) {

    fun create(newReservation: Reservation): Reservation {
        if (!isAvailableToReserve(newReservation.from, newReservation.to, newReservation.room)) throw ReservationNotAvailable()
        return reservationRepository.save(newReservation)
    }

    fun findAll(): List<Reservation> = reservationRepository.findAll()

    fun findById(id: Long): Reservation {
        val reservation = reservationRepository.findById(id)
        if (reservation.isEmpty) throw ReservationNotExistException()
        return reservation.get()
    }

    fun findAllByUserId(id: Long): List<Reservation> {
        val user = userRepository.findById(id)
        if (user.isEmpty) throw UserNotExistException()
        return reservationRepository.findAllByUserId(id)
    }

    // Get all the rooms that are available to reserve on specific dates(from, to)
    fun findRoomsAvailableToReserveOnDates(from: Date, to: Date): List<Reservation>? {
        return null
    }

    private fun isAvailableToReserve(from: Date, to: Date, room: Room): Boolean {
        val reservationsOnDates: List<Reservation> = reservationRepository.findAllByRoomBetweenDates(room.id, from, to)
        if (reservationsOnDates.isNotEmpty()) return false
        return true
    }

}
