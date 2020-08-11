package com.rodrigol.hotel.repository

import com.rodrigol.hotel.model.Reservation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ReservationRepository: JpaRepository<Reservation, Long> {

    @Query(
            value = "SELECT r.* FROM `reservations` r " +
                    "INNER JOIN `users` u ON r.id_user = u.id " +
                    "INNER JOIN `rooms` rm ON r.id_room = rm.id " +
                    "WHERE (r.from)",
            nativeQuery = true
    )
    fun findAllBetweenDates(from: Date, to: Date): List<Reservation>

    @Query(
            value = "SELECT r.* FROM `reservations` r " +
                    "WHERE r.id_user = ?1",
            nativeQuery = true
    )
    fun findAllByUserId(id: Long): List<Reservation>

}