package com.thanst.admin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AdminApp

fun main(args: Array<String>) {
    runApplication<AdminApp>(*args)
}
