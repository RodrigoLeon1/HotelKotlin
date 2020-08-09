package com.rodrigol.hotel.utils

import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI


class RestUtils {

    companion object {
        @JvmStatic
        fun getLocation(id: Long): URI = ServletUriComponentsBuilder
                                            .fromCurrentRequest()
                                            .path("/{id}")
                                            .buildAndExpand(id)
                                            .toUri()
    }

}