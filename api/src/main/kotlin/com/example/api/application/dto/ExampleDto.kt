package com.example.multimoduleprojectexample.com.example.api.application.dto

import com.example.core.domain.Example

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