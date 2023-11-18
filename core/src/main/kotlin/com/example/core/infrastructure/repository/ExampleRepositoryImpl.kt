package com.example.core.infrastructure.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.example.core.domain.Example
import com.example.core.domain.QExample.example
import org.springframework.stereotype.Repository

@Repository
class ExampleRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
): ExampleRepositoryCustom {

    override fun findExampleById(id: Long): Example? {
        return jpaQueryFactory.select(example)
            .from(example)
            .where(example.id.eq(id))
            .fetchOne()
    }
}
