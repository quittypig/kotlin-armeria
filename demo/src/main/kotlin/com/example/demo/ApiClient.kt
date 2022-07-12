package com.example.demo

import org.springframework.stereotype.Service

@Service
class ApiClient {
    fun account(): AccountApiClient {
        return AccountApiClient()
    }
}
