package com.example.core.domain

import com.example.core.infrastructure.repository.ExampleRepositoryCustom
import org.springframework.data.jpa.repository.JpaRepository

interface ExampleRepository: JpaRepository<Example, Long>, ExampleRepositoryCustom {
}
