package com.rodrigol.hotel.service

import com.rodrigol.hotel.exception.reservation.ReservationNotAvailable
import com.rodrigol.hotel.exception.reservation.ReservationNotExistException
import com.rodrigol.hotel.model.Reservation
import com.rodrigol.hotel.model.Room
import com.rodrigol.hotel.repository.ReservationRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ReservationService(private val reservationRepository: ReservationRepository) {

    fun create(newReservation: Reservation): Reservation {
        if (!availableToReserve(newReservation.from, newReservation.to, newReservation.room)) throw ReservationNotAvailable()
        return reservationRepository.save(newReservation)
    }

    fun findAll(): List<Reservation> = reservationRepository.findAll()

    fun findById(id: Long): Reservation {
        val reservation = reservationRepository.findById(id)
        if (reservation.isEmpty) throw ReservationNotExistException()
        return reservation.get()
    }

    fun findAllByUserId(id: Long): List<Reservation> {
        return reservationRepository.findAllByUserId(id)
    }

    //
    private fun availableToReserve(from: Date, to: Date, room: Room): Boolean {
        val reservationsOnDates: List<Reservation> = reservationRepository.findAllBetweenDates(from, to)

        return true
    }

}
