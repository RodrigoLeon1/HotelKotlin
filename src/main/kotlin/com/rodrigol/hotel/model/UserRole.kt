package com.rodrigol.hotel.model

import javax.persistence.*

@Entity
@Table(name = "user_roles")
class UserRole(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val role: String

)