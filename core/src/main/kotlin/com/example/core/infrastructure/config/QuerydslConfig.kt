package com.example.core.infrastructure.config

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QuerydslConfig {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @Bean
    fun jpaQuerydslFactory(): JPAQueryFactory {
        return JPAQueryFactory(entityManager)
    }
}
