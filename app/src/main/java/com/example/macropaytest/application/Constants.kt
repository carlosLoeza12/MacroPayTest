package com.example.macropaytest.application

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object Constants {
    //API
    const val BASE_URL = "http://testandroid.macropay.com.mx"

    // Create Logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    var okHttp = OkHttpClient.Builder().addInterceptor(logger)
}