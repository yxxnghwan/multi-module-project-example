package com.example.multimoduleprojectexample.infrastructure.repository

import com.example.multimoduleprojectexample.domain.Example
import com.example.multimoduleprojectexample.domain.QExample.*
import com.querydsl.jpa.impl.JPAQueryFactory
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
