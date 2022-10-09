package com.example.macropaytest.repository

import com.example.macropaytest.data.model.Response
import com.example.macropaytest.data.remote.DataSource
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val dataSource: DataSource) : Repository {
    override suspend fun makeLogin(email: String, password: String): Response {
        return dataSource.makeLogin(email, password)
    }
}