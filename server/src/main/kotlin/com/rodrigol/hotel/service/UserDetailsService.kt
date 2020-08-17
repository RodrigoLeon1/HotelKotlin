package com.rodrigol.hotel.service

import com.rodrigol.hotel.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserDetailsService(val userRepository: UserRepository) : UserDetailsService {

    @Transactional(readOnly = true)
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(dni: String): UserDetails {
        val user = userRepository.findByDni(dni) ?: throw UsernameNotFoundException(dni)
        return User(user.dni, user.password, emptyList())
    }

    fun save(user: com.rodrigol.hotel.model.User) {
        userRepository.save(user)
    }

}