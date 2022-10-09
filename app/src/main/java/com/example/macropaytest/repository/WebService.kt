package com.example.macropaytest.repository

import com.example.macropaytest.data.model.Response
import retrofit2.http.*

interface WebService {
    @FormUrlEncoded
    @POST(".")
    suspend fun makeLogin(@Field("email") email: String, @Field("password") password: String,): Response
}