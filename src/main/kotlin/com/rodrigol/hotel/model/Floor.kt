package com.rodrigol.hotel.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "room_floors")
class Floor(

    @Id
    @GeneratedValue
    val id: Long,

    val floor: String

)
