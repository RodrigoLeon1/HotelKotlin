package com.rodrigol.hotel.dto.user

import com.rodrigol.hotel.model.UserRole

data class UserPostDTO(
    val name: String,
    val surname: String,
    val dni: String,
    val password: String,
    val roles: Set<UserRole>
)