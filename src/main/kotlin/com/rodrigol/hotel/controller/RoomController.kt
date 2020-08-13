package com.rodrigol.hotel.controller

import com.rodrigol.hotel.model.Room
import com.rodrigol.hotel.service.RoomService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/rooms")
class RoomController(private val roomService: RoomService) {

    @GetMapping("/")
    fun findAll(): ResponseEntity<List<Room>> {
        val rooms = roomService.findAll()
        return if (rooms.isNotEmpty()) ResponseEntity.ok(rooms) else ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Room> = ResponseEntity.ok(roomService.findById(id))

    @PutMapping("/{id}")
    fun updateById(@PathVariable id: Long, @RequestBody updatedRoom: Room): ResponseEntity<Any> {
        return ResponseEntity.ok(roomService.updateById(id, updatedRoom))
    }

}