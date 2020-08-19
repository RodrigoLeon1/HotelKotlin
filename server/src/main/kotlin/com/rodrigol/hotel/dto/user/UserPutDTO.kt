package com.rodrigol.hotel.dto.user

import com.rodrigol.hotel.model.UserRole

data class UserPutDTO(
    val name: String,
    val surname: String,
    val dni: String,
    val password: String?,
    val isActive: Boolean?,
    val roles: Set<UserRole>?
)