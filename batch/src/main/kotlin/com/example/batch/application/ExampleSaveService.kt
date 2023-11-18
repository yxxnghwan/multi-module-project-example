package com.example.batch.application

import com.example.core.domain.Example
import com.example.core.domain.ExampleRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ExampleSaveService(
    private val exampleRepository: ExampleRepository,
) {

    @Transactional
    fun save(): String {
        return exampleRepository.save(Example("batch created")).content
    }
}
