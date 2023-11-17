package com.example.multimoduleprojectexample.application.dto

import com.example.multimoduleprojectexample.domain.Example

data class ExampleDto(
    val id: Long,
    val content: String,
) {

    companion object {
        fun from(entity: Example): ExampleDto {
            return ExampleDto(
                entity.id,
                entity.content
            )
        }
    }
}