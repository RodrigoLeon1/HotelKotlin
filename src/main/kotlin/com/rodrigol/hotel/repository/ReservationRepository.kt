package com.rodrigol.hotel.repository

import com.rodrigol.hotel.model.Reservation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ReservationRepository: JpaRepository<Reservation, Long> {

    @Query(
            value = "",
            nativeQuery = true
    )
    fun findAllBetweenFromAndTo(from: Date, to: Date): List<Reservation>

}