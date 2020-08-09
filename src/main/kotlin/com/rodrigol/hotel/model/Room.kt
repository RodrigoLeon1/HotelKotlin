package com.rodrigol.hotel.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "rooms")
class Room(

    @Id @GeneratedValue val id: Long,
    val number: String,
    val status: RoomStatus,
    val roomFloor: Floor,
    val roomType: RoomType

)