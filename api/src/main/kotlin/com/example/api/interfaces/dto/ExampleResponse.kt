package com.example.multimoduleprojectexample.com.example.api.interfaces.dto

import com.example.multimoduleprojectexample.com.example.api.application.dto.ExampleDto
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
