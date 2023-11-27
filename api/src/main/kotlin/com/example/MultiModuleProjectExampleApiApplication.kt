package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MultiModuleProjectExampleApiApplication

fun main(args: Array<String>) {
	runApplication<MultiModuleProjectExampleApiApplication>(*args)
}
