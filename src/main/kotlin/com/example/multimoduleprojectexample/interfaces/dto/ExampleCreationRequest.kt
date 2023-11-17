package com.example.multimoduleprojectexample.interfaces.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy::class)
data class ExampleCreationRequest(
    val content: String,
) {
}