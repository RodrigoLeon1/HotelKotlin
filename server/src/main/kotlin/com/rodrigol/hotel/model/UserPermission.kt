package com.rodrigol.hotel.model

// soon...
enum class UserPermission(private final val permission: String) {

    ADMIN_WRITE("admin:write"),
    ADMIN_READ("admin:read");

    fun getPermission(): String = permission

}