package com.rodrigol.hotel.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "room_types")
class RoomType(

    @Id
    @GeneratedValue
    val id: Long,

    val type: String

)