package com.example.multimoduleprojectexample.interfaces.dto

import com.example.multimoduleprojectexample.application.dto.ExampleDto
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy::class)
data class ExampleResponse(
    val id: Long,
    val content: String,
) {

    companion object {
        fun from(dto: ExampleDto) : ExampleResponse {
            return ExampleResponse(dto.id, dto.content)
        }
    }
}
