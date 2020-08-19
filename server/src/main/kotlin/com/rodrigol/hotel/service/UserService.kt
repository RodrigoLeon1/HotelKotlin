package com.rodrigol.hotel.service

import com.rodrigol.hotel.exception.user.UserAlreadyExistException
import com.rodrigol.hotel.exception.user.UserNotExistException
import com.rodrigol.hotel.model.User
import com.rodrigol.hotel.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import org.springframework.stereotype.Service
//import java.sql.SQLIntegrityConstraintViolationException

@Service
class UserService(
        private val userRepository: UserRepository,
        private val bCryptPasswordEncoder: BCryptPasswordEncoder
) {

    fun create(newUser: User): User {
        val existUser = findByDni(newUser.dni)
        if (null != existUser) throw UserAlreadyExistException()
        // Hash the password
        newUser.password = bCryptPasswordEncoder.encode(newUser.password)
        return userRepository.save(newUser)
    }

    fun findAll(): List<User> = userRepository.findAll()

    fun findById(id: Long): User {
        val user = userRepository.findById(id)
        if (user.isEmpty) throw UserNotExistException()
        return user.get()
    }

    fun findByDni(dni: String): User? = userRepository.findByDni(dni)

    fun updateById(id: Long, updatedUser: User): User {
        try {

            val existUser = findById(id)
            updatedUser.id = existUser.id
            updatedUser.password = bCryptPasswordEncoder.encode(updatedUser.password)
            return userRepository.save(updatedUser)

        } catch (e: Exception) {    // Search exception...
            throw UserAlreadyExistException()
        }
    }

}

