package com.rodrigol.hotel.repository

import com.rodrigol.hotel.model.Room
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface RoomRepository: JpaRepository<Room, Long> {

    @Transactional
    @Modifying
    @Query(
            value = "UPDATE `rooms` r " +
                    "SET r.status = ?2 " +
                    "WHERE r.id = ?1",
            nativeQuery = true
    )
    fun updateById(
            id: Long,
            status: String
    ): Int

}