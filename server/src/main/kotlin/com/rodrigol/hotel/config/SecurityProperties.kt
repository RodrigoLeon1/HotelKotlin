package com.rodrigol.hotel.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt-security")
class SecurityProperties {

    var secret = ""
    var expirationTime: Int = 31
    var tokenPrefix = "Bearer "
    var headerString = "Authorization"

}