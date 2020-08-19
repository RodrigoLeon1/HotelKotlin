package com.rodrigol.hotel.model

import javax.persistence.*

@Entity
@Table(name = "rooms")
class Room(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    val number: String,

    @Enumerated(value = EnumType.STRING)
    var status: RoomStatus,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_room_floor")
    val roomFloor: Floor,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_room_type")
    val roomType: RoomType

)