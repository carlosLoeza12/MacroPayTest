package com.example.macropaytest.data.remote

import com.example.macropaytest.repository.WebService
import javax.inject.Inject

class DataSource @Inject constructor(private val webService: WebService) {
    suspend fun makeLogin(email: String, password: String): com.example.macropaytest.data.model.Response{
        return webService.makeLogin(email, password)
    }
}