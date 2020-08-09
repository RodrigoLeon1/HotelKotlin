package com.rodrigol.hotel.model

import javax.persistence.*

@Entity
@Table(name = "room_floors")
class Floor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val floor: String

)
