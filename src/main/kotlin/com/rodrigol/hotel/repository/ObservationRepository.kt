package com.rodrigol.hotel.repository

import com.rodrigol.hotel.model.Observation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ObservationRepository: JpaRepository<Observation, Long> {

    @Query(
            value = "SELECT o.* FROM `observations` o " +
                    "WHERE o.id_user = ?1",
            nativeQuery = true
    )
    fun findAllByUserId(id: Long): List<Observation>

}