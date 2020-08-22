package com.rodrigol.hotel.security.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.rodrigol.hotel.security.config.EXPIRATION_TIME
import com.rodrigol.hotel.security.config.HEADER_STRING_AUTH
import com.rodrigol.hotel.security.config.SECRET
import com.rodrigol.hotel.security.config.TOKEN_PREFIX
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.io.IOException
import java.util.Date
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthenticationFilter(authManager: AuthenticationManager) : UsernamePasswordAuthenticationFilter() {

    init {
        authenticationManager = authManager
    }

    @Throws(AuthenticationException::class, IOException::class, ServletException::class)
    override fun attemptAuthentication(req: HttpServletRequest, res: HttpServletResponse): Authentication {

        val credentials = ObjectMapper().readValue(req.inputStream, com.rodrigol.hotel.model.User::class.java)

        val authentication =  UsernamePasswordAuthenticationToken(
                credentials.dni,
                credentials.password,
                emptyList<GrantedAuthority>()
        )

        return authenticationManager.authenticate(authentication)
    }

    override fun successfulAuthentication(req: HttpServletRequest,
                                          res: HttpServletResponse,
                                          chain: FilterChain?,
                                          auth: Authentication) {

        val tokenJwt = Jwts.builder()
                                .setSubject((auth.principal as User).username)
                                .claim("authorities", auth.authorities)
                                .setIssuedAt(Date())
                                .setExpiration(Date(System.currentTimeMillis() + EXPIRATION_TIME))
                                .signWith(SignatureAlgorithm.HS512, SECRET)
                                .compact()

        res.addHeader(HEADER_STRING_AUTH, "$TOKEN_PREFIX $tokenJwt")
    }

}