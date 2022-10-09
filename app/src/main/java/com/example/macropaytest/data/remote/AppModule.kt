package com.example.macropaytest.data.remote

import com.example.macropaytest.application.Constants
import com.example.macropaytest.repository.WebService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(Constants.okHttp.build())
            .build()


    @Singleton
    @Provides
    fun provideMovieService(retrofit: Retrofit): WebService = retrofit.create(WebService::class.java)
}