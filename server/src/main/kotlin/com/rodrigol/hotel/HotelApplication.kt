package com.rodrigol.hotel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication


@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
//@SpringBootApplication()
class HotelApplication

fun main(args: Array<String>) {
	runApplication<HotelApplication>(*args)
}
