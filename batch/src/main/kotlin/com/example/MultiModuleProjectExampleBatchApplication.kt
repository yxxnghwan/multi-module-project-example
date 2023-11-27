package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MultiModuleProjectExampleBatchApplication

fun main(args: Array<String>) {
	runApplication<MultiModuleProjectExampleBatchApplication>(*args)
}
