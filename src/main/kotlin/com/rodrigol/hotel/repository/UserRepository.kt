package com.rodrigol.hotel.repository

import com.rodrigol.hotel.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface UserRepository: JpaRepository<User, Long> {

    fun findByDni(dni: String): User?

    @Transactional
    @Modifying
    @Query(
            value = "UPDATE `users` u " +
                    "SET u.name = ?2, u.surname = ?3, u.dni = ?4 " +
                    "WHERE u.id = ?1",
            nativeQuery = true
    )
    fun updateById(id: Long, name: String, surname: String, dni: String): Boolean

}