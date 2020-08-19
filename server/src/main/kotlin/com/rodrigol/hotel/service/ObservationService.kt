package com.rodrigol.hotel.service

import com.rodrigol.hotel.exception.observation.ObservationNotExistException
import com.rodrigol.hotel.exception.user.UserNotExistException
import com.rodrigol.hotel.model.Observation
import com.rodrigol.hotel.repository.ObservationRepository
import com.rodrigol.hotel.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class ObservationService(
        private val observationRepository: ObservationRepository,
        private val userRepository: UserRepository
) {

    fun create(newObservation: Observation): Observation {
        return observationRepository.save(newObservation)
    }

    fun findAllByUserId(id: Long): List<Observation> {
        val user = userRepository.findById(id)
        if (user.isEmpty) throw UserNotExistException()
        return observationRepository.findAllByUserId(id)
    }

    fun findById(id: Long): Observation {
        val observation = observationRepository.findById(id)
        if (observation.isEmpty) throw ObservationNotExistException()
        return observation.get()
    }

}