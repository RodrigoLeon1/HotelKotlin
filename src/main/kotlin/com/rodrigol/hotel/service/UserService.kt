package com.rodrigol.hotel.service

import com.rodrigol.hotel.exception.user.UserAlreadyExistException
import com.rodrigol.hotel.model.User
import com.rodrigol.hotel.repository.UserRepository

import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {

    fun create(newUser: User): User {
        val existUser = findByDni(newUser.dni)
        if (existUser != null) {
            throw UserAlreadyExistException()
        }
        return userRepository.save(newUser)
    }

    fun findAll(): List<User> = userRepository.findAll()

    fun findById(id: Long): Optional<User> = userRepository.findById(id)

    fun findByDni(dni: String): User? = userRepository.findByDni(dni)

    //fun deleteById(id: Long): Boolean = userRepository.deleteById(id)

}

