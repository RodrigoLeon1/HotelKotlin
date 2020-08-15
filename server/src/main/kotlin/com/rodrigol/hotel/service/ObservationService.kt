package com.rodrigol.hotel.service

import com.rodrigol.hotel.exception.observation.ObservationNotExistException
import com.rodrigol.hotel.model.Observation
import com.rodrigol.hotel.repository.ObservationRepository
import org.springframework.stereotype.Service

@Service
class ObservationService(private val observationRepository: ObservationRepository) {

    fun create(newObservation: Observation): Observation {
        return observationRepository.save(newObservation)
    }

    fun findAllByUserId(id: Long): List<Observation> {
        return observationRepository.findAllByUserId(id)
    }

    fun findById(id: Long): Observation {
        val observation = observationRepository.findById(id)
        if (observation.isEmpty) throw ObservationNotExistException()
        return observation.get()
    }

}