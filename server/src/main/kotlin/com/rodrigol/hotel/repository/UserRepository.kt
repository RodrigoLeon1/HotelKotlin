package com.rodrigol.hotel.repository

import com.rodrigol.hotel.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {

    fun findByDni(dni: String): User?

}