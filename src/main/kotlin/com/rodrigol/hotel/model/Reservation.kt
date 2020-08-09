package com.rodrigol.hotel.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "reservations")
class Reservation(

    @Id
    @GeneratedValue
    val id: Long,

    val from: Date,
    val to: Date,
    val totalQuantity: Int,
    val totalAdults: Int,
    val totalChildren: Int,
    val creationDate: Date,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    val userReservation: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_room")
    val room: Room

)