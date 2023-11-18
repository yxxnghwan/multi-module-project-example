package com.example.core.infrastructure.repository

import com.example.core.domain.Example

interface ExampleRepositoryCustom {

    fun findExampleById(id: Long): Example?
}
