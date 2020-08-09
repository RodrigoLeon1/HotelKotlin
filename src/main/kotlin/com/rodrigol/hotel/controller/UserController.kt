package com.rodrigol.hotel.controller

import com.rodrigol.hotel.model.User
import com.rodrigol.hotel.service.UserService
import com.rodrigol.hotel.utils.RestUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @PostMapping("/")
    fun create(@RequestBody newUser: User): ResponseEntity<Any> {
        val userAdded = userService.create(newUser)
        return ResponseEntity.created(RestUtils.getLocation(userAdded.id)).build()
    }

    @GetMapping("/")
    fun findAll(): ResponseEntity<List<User>> {
        val users = userService.findAll()
        return if (users.isNotEmpty()) ResponseEntity.ok(users) else ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Optional<User>> = ResponseEntity.ok(userService.findById(id))

    //@DeleteMapping("/{id}")
    //fun deleteById(@PathVariable id: Long) = userService.deleteById(id)

}