package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication
private val logger = LoggerFactory.getLogger(DemoApplication::class.java)
fun main(args: Array<String>) {
    logger.info("Debug message");
    runApplication<DemoApplication>(*args)
}
