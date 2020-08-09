package com.rodrigol.hotel.service

import com.rodrigol.hotel.model.User
import com.rodrigol.hotel.repository.UserRepository

import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {

    fun create(newUser: User): User = userRepository.save(newUser)

    fun findAll(): List<User> = userRepository.findAll()

    fun findById(id: Long): Optional<User> = userRepository.findById(id)

    fun findByDni(dni: String): User? = userRepository.findByDni(dni)

}

