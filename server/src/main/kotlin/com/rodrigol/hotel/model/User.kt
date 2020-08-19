package com.rodrigol.hotel.model

import com.rodrigol.hotel.dto.user.UserGetDTO
import com.rodrigol.hotel.dto.user.UserPostDTO
import com.rodrigol.hotel.dto.user.UserPutDTO
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    var name: String,
    var surname: String,
    var dni: String,
    var password: String,
    var creationDate: Date?,
    var isActive: Boolean?,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_x_user_roles",
            joinColumns = [JoinColumn(name = "id_user")],
            inverseJoinColumns = [JoinColumn(name = "id_user_role")]
    )
    var roles: Set<UserRole>

) {

    fun toDto() = UserGetDTO(
            id = this.id,
            name = name,
            surname = surname,
            dni = dni
    )

    companion object {

        fun fromDTO(userDTO: UserPostDTO) = User(
                id = null,
                name = userDTO.name,
                surname = userDTO.surname,
                dni = userDTO.dni,
                password = userDTO.password,
                creationDate = null,
                isActive = true,
                roles = userDTO.roles
                //lastModified = LocalDateTime.now(),
        )

        fun fromDTO(userDTO: UserPutDTO) = User(
                id = null,
                name = userDTO.name,
                surname = userDTO.surname,
                dni = userDTO.dni,
                password = userDTO.password!!,
                creationDate = null,
                isActive = true,
                roles = userDTO.roles!!
        )

    }
    
}