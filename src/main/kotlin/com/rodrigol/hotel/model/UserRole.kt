package com.rodrigol.hotel.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user_roles")
class UserRole(

    @Id @GeneratedValue val id: Long,
    val role: String

)