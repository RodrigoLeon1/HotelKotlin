package com.rodrigol.hotel.service

import com.rodrigol.hotel.exception.user.UserAlreadyExistException
import com.rodrigol.hotel.exception.user.UserNotExistException
import com.rodrigol.hotel.model.User
import com.rodrigol.hotel.repository.UserRepository

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun create(newUser: User): User {
        val existUser = findByDni(newUser.dni)
        if (existUser != null) throw UserAlreadyExistException()
        return userRepository.save(newUser)
    }

    fun findAll(): List<User> = userRepository.findAll()

    fun findById(id: Long): User {
        val user = userRepository.findById(id)
        if (user.isEmpty) throw UserNotExistException();
        return user.get()
    }

    fun findByDni(dni: String): User? = userRepository.findByDni(dni)

    fun updateById(id: Long, updatedUser: User): Boolean {
        val existUser = findById(id)
        return userRepository.updateById(id, updatedUser.name, updatedUser.surname, updatedUser.dni)
    }

}

