package com.example.batch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EntityScan("com.example")
@EnableJpaRepositories(value = ["com.example"])
@SpringBootApplication(scanBasePackages = ["com.example"])
class MultiModuleProjectExampleBatchApplication

fun main(args: Array<String>) {
	runApplication<MultiModuleProjectExampleBatchApplication>(*args)
}
