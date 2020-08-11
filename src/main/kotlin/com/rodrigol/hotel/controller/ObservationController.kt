package com.rodrigol.hotel.controller

import com.rodrigol.hotel.model.Observation
import com.rodrigol.hotel.service.ObservationService
import com.rodrigol.hotel.utils.RestUtils
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/observations")
class ObservationController(private val observationService: ObservationService) {

    @PostMapping("/")
    fun create(@RequestBody newObservation: Observation): ResponseEntity<Any> {
        val observationAdded = observationService.create(newObservation)
        return ResponseEntity.created(RestUtils.getLocation(observationAdded.id)).build()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Observation> = ResponseEntity.ok(observationService.findById(id))

}