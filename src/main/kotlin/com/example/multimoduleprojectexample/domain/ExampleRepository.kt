package com.example.multimoduleprojectexample.domain

import com.example.multimoduleprojectexample.infrastructure.repository.ExampleRepositoryCustom
import org.springframework.data.jpa.repository.JpaRepository

interface ExampleRepository: JpaRepository<Example, Long>, ExampleRepositoryCustom {
}
