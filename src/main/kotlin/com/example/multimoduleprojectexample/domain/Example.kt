package com.example.multimoduleprojectexample.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "example")
class Example(
    content: String,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var content: String = content
        private set

    fun updateContent(newContent: String) {
        this.content = newContent
    }
}
