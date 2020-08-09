package com.rodrigol.hotel.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController {

    @GetMapping("/")
    fun findAll(): ResponseEntity<String> = ResponseEntity.ok("Works!")

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): ResponseEntity<String> = ResponseEntity.ok("User get by ID")



}