package com.rodrigol.hotel.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "reservations")
class Reservation(

    @Id @GeneratedValue val id: Long,
    val from: Date,
    val to: Date,
    val totalQuantity: Int,
    val totalAdults: Int,
    val totalChildren: Int,
    val creationDate: Date,
    val user: User,
    val room: Room

)