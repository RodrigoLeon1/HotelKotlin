package com.rodrigol.hotel.controller

import com.rodrigol.hotel.model.Reservation
import com.rodrigol.hotel.service.ReservationService
import com.rodrigol.hotel.utils.RestUtils
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/reservations")
class ReservationController(private val reservationService: ReservationService) {

    @PostMapping("/")
    fun create(@RequestBody newReservation: Reservation): ResponseEntity<Any> {
        val reservationAdded = reservationService.create(newReservation)
        return ResponseEntity.created(RestUtils.getLocation(reservationAdded.id)).build()
    }

    @GetMapping("/")
    fun findAll(): ResponseEntity<List<Reservation>> {
        val reservations = reservationService.findAll()
        return if (reservations.isNotEmpty()) ResponseEntity.ok(reservations) else ResponseEntity.noContent().build()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Reservation> = ResponseEntity.ok(reservationService.findById(id))

}