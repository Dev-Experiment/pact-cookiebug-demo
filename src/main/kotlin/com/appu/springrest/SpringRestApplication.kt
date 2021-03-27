package com.appu.springrest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SpringRestApplication

fun main(args: Array<String>) {
	runApplication<SpringRestApplication>(*args)
}
