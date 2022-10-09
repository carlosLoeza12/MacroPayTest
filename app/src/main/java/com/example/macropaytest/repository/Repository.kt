package com.example.macropaytest.repository

import com.example.macropaytest.data.model.Response

interface Repository {
    suspend fun makeLogin(email: String, password: String):Response
}