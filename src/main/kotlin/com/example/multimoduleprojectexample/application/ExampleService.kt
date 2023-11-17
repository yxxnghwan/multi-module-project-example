package com.example.multimoduleprojectexample.application

import com.example.multimoduleprojectexample.application.dto.ExampleDto
import com.example.multimoduleprojectexample.domain.Example
import com.example.multimoduleprojectexample.domain.ExampleRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ExampleService(
    private val exampleRepository: ExampleRepository
) {

    @Transactional
    fun createExample(content: String): ExampleDto {
        val example = Example(content)
        val savedExample = exampleRepository.save(example)
        return ExampleDto.from(savedExample)
    }

    @Transactional(readOnly = true)
    fun getExample(id: Long): ExampleDto {
        val example = exampleRepository.findExampleById(id)
            ?: throw RuntimeException("없는 엔티티입니다. id = $id")
        return ExampleDto.from(example)
    }

    @Transactional
    fun updateExample(id: Long, content: String): ExampleDto {
        val example = exampleRepository.findExampleById(id)
            ?: throw RuntimeException("없는 엔티티입니다. id = $id")
        example.updateContent(content)
        return ExampleDto.from(example)
    }

    @Transactional
    fun deleteExample(id: Long) {
        exampleRepository.deleteById(id)
    }
}
