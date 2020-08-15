package com.rodrigol.hotel.security

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.rodrigol.hotel.config.SecurityProperties
import com.rodrigol.hotel.utils.add
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationServiceException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.io.IOException
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class JWTAuthenticationFilter(
        private val authManager: AuthenticationManager,
        private val securityProperties: SecurityProperties
) : UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(
            req: HttpServletRequest,
            res: HttpServletResponse?
    ): Authentication {
        return try {

            val mapper = jacksonObjectMapper()

            val creds = mapper.readValue<com.rodrigol.hotel.model.User>(req.inputStream)

            authManager.authenticate(
                    UsernamePasswordAuthenticationToken(
                            creds.dni,
                            creds.password,
                            ArrayList<GrantedAuthority>()
                    )
            )
        } catch (e: IOException) {
            throw AuthenticationServiceException(e.message)
        }
    }

    override fun successfulAuthentication(
            req: HttpServletRequest,
            res: HttpServletResponse,
            chain: FilterChain?,
            auth: Authentication
    ) {
        val claims: MutableList<String> = mutableListOf()
        if (auth.authorities.isNotEmpty())
            auth.authorities.forEach { a -> claims.add(a.toString()) }

        val token = Jwts.builder()
                .setSubject((auth.principal as User).username)
                .claim("auth", claims)
                .setExpiration(Date().add(Calendar.DAY_OF_MONTH, securityProperties.expirationTime))
                .signWith(Keys.hmacShaKeyFor(securityProperties.secret.toByteArray()), SignatureAlgorithm.HS512)
                .compact()
        res.addHeader(securityProperties.headerString, securityProperties.tokenPrefix + token)
    }

}