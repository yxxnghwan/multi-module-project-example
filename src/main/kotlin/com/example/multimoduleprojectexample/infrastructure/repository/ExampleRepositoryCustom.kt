package com.example.multimoduleprojectexample.infrastructure.repository

import com.example.multimoduleprojectexample.domain.Example

interface ExampleRepositoryCustom {

    fun findExampleById(id: Long): Example?
}
