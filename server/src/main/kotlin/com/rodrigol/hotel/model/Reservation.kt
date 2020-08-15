package com.rodrigol.hotel.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "reservations")
class Reservation(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "`from`")
    val from: Date,

    @Column(name = "`to`")
    val to: Date,

    val totalQuantity: Int,
    val totalAdults: Int,
    val totalChildren: Int,
    val creationDate: Date,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    val user: User,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_room")
    val room: Room

)