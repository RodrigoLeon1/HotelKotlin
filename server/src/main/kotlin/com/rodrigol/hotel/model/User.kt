package com.rodrigol.hotel.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    var name: String,
    var surname: String,
    var dni: String,
    var password: String,
    var creationDate: Date,
    var isActive: Boolean,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_x_user_roles",
            joinColumns = [JoinColumn(name = "id_user")],
            inverseJoinColumns = [JoinColumn(name = "id_user_role")]
    )
    var roles: Set<UserRole>

)