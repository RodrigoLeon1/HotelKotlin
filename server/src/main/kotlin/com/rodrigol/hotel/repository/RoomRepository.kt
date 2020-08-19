package com.rodrigol.hotel.repository

import com.rodrigol.hotel.model.Room
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository: JpaRepository<Room, Long> {
}