package com.example.multimoduleprojectexample.com.example.api.interfaces.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy::class)
data class ExampleCreationRequest(
    val content: String,
) {
}