package com.rodrigol.hotel.service

import com.rodrigol.hotel.repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserDetailsService(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(s: String): UserDetails {
        val user = userRepository.findByDni(s) ?: throw UsernameNotFoundException("The DNI $s does not exist")

        val authorities = ArrayList<GrantedAuthority>()
        user.roles.forEach { authorities.add(SimpleGrantedAuthority(it.role)) }

        return User(user.dni, user.password, authorities)
    }

}