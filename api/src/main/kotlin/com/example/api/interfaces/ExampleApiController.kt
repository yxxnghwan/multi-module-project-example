package com.example.multimoduleprojectexample.com.example.api.interfaces

import com.example.multimoduleprojectexample.com.example.api.application.ExampleService
import com.example.multimoduleprojectexample.com.example.api.interfaces.dto.ExampleCreationRequest
import com.example.multimoduleprojectexample.com.example.api.interfaces.dto.ExampleResponse
import com.example.multimoduleprojectexample.com.example.api.interfaces.dto.ExampleUpdateRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/examples")
class ExampleApiController(
    private val exampleService: ExampleService
) {

    @PostMapping
    fun postExample(@RequestBody request: ExampleCreationRequest): ResponseEntity<ExampleResponse> {
        val exampleDto = exampleService.createExample(request.content)
        return ResponseEntity.ok(ExampleResponse.from(exampleDto))
    }

    @GetMapping("/{id}")
    fun getExample(@PathVariable id: Long): ResponseEntity<ExampleResponse> {
        val exampleDto = exampleService.getExample(id)
        return ResponseEntity.ok(ExampleResponse.from(exampleDto))
    }

    @PutMapping
    fun updateExample(@RequestBody request: ExampleUpdateRequest): ResponseEntity<ExampleResponse> {
        val exampleDto = exampleService.updateExample(request.id, request.content)
        return ResponseEntity.ok(ExampleResponse.from(exampleDto))
    }

    @DeleteMapping("/{id}")
    fun deleteExample(@PathVariable id: Long): ResponseEntity<Unit> {
        exampleService.deleteExample(id)
        return ResponseEntity.noContent().build()
    }
}
