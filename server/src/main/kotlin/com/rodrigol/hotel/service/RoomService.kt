package com.rodrigol.hotel.service

import com.rodrigol.hotel.exception.room.RoomNotExistException
import com.rodrigol.hotel.model.Room
import com.rodrigol.hotel.repository.RoomRepository
import org.springframework.stereotype.Service

@Service
class RoomService(private val roomRepository: RoomRepository) {

    fun findAll(): List<Room> = roomRepository.findAll()

    fun findById(id: Long): Room {
        val room = roomRepository.findById(id)
        if (room.isEmpty) throw RoomNotExistException()
        return room.get()
    }

    fun updateById(id: Long, updatedRoom: Room): Room {
        val existRoom = findById(id)
        updatedRoom.id = existRoom.id
        return roomRepository.save(updatedRoom)
    }

}