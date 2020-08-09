package com.rodrigol.hotel.controller

import com.rodrigol.hotel.model.User
import com.rodrigol.hotel.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @GetMapping("/")
    fun findAll(): ResponseEntity<List<User>> = ResponseEntity.ok(userService.findAll())

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Optional<User>> = ResponseEntity.ok(userService.findById(id))



}