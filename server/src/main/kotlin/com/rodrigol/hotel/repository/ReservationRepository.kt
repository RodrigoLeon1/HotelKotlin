package com.rodrigol.hotel.repository

import com.rodrigol.hotel.model.Reservation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ReservationRepository: JpaRepository<Reservation, Long> {

    // Bad query... Fix...
    @Query(
            value = "SELECT r.* FROM `reservations` r " +
                    "WHERE (r.id_room = ?1) AND ((DATE(r.from) >= ?2) AND (DATE(r.to) <= ?3))",
            nativeQuery = true
    )
    fun findAllByRoomBetweenDates(
            room: Long,
            from: Date,
            to: Date
    ): List<Reservation>

    @Query(
            value = "SELECT r.* FROM `reservations` r " +
                    "WHERE r.id_user = ?1",
            nativeQuery = true
    )
    fun findAllByUserId(id: Long): List<Reservation>

}