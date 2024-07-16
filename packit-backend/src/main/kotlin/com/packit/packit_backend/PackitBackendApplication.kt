package com.packit.packit_backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration

@Configuration
public class PackitBackendApplication {

}


fun main(args: Array<String>) {
    runApplication<PackitBackendApplication>(*args)
}
