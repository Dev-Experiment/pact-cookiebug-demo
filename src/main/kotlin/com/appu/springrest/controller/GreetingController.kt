package com.appu.springrest.controller

import com.appu.springrest.model.Greeting
import com.appu.springrest.service.GreetingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.*

import java.time.OffsetDateTime
import java.util.*

import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {
    private val template = "Hello, %s!"
    @Autowired
    private lateinit var service: GreetingService

    @GetMapping("/greeting/{vehicleUuid}")
    @Suppress("UNUSED_PARAMETER")
    fun greeting(
        @PathVariable vehicleUuid: UUID,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) startTime: OffsetDateTime,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) endTime: OffsetDateTime,
        //@RequestHeader("Cookie") token: String
        @CookieValue("token") token: String
        ) : Greeting?
        {

        return service.getTokenGreeting(token)
    }

}