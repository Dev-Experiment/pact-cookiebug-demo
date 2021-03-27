package com.appu.springrest.service

import com.appu.springrest.model.Greeting
import org.springframework.stereotype.Service

@Service
open class GreetingService  (){
    fun getTokenGreeting(token: String): Greeting {
        return Greeting (0, token)
    }
}