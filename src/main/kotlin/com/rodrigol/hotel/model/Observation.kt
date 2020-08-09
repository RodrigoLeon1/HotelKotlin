package com.rodrigol.hotel.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "observations")
class Observation(

    @Id
    @GeneratedValue
    val id: Long,

    val description: String,
    val creationDate: Date,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    val userObservation: User

)