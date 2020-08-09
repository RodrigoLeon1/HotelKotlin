package com.rodrigol.hotel.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "observations")
class Observation(

    @Id @GeneratedValue val id: Long,
    val description: String,
    val creationDate: Date,
    val user: User

)