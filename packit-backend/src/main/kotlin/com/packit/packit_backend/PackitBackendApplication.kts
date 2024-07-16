package com.packit.packit_backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PackitBackendApplication{
    // Your application's main class goes here...
}

fun main(args: Array<String>) {
    runApplication<PackitBackendApplication>(*args)
}
