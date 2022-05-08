package com.example.sampleTodo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController() {
    @GetMapping
    fun get(): String {
        return "OK"
    }
}
