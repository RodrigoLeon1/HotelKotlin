package com.rodrigol.hotel.service

import com.rodrigol.hotel.exception.auth.AuthNotEnabledException
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
    override fun loadUserByUsername(dni: String): UserDetails {
        val user = userRepository.findByDni(dni) ?: throw UsernameNotFoundException(dni)

        if (!user.isActive!!) throw AuthNotEnabledException()

        return User(user.dni, user.password, emptyList())
    }

}