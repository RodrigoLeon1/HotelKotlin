package com.rodrigol.hotel.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val name: String,
    val surname: String,
    val dni: String,
    val password: String,
    val creationDate: Date,
    val isActive: Boolean,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_x_user_roles",
            joinColumns = [JoinColumn(name = "id_user")],
            inverseJoinColumns = [JoinColumn(name = "id_user_role")]
    )
    val roles: Set<UserRole>,

    @OneToMany(mappedBy = "userObservation")
    val observations: List<Observation>,

    @OneToMany(mappedBy = "userReservation")
    val reservation: List<Reservation>

)