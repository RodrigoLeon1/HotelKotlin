package com.rodrigol.hotel.model

import javax.persistence.*

@Entity
@Table(name = "room_types")
class RoomType(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val type: String

)