package com.example.randombarfinder.data.remote

import PlacesService
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

fun createPlacesService(apiKey: String): PlacesService {
    val json = Json { ignoreUnknownKeys = true }

    val keyInterceptor = Interceptor { chain ->
        val request = chain.request()
            .newBuilder()
            .addHeader("X-Goog-Api-Key", apiKey)
            .build()
        chain.proceed(request)
    }

    val client = OkHttpClient.Builder()
        .addInterceptor(keyInterceptor)
        .build()

    return Retrofit.Builder()
        .baseUrl("https://places.googleapis.com/")
        .client(client)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(PlacesService::class.java)
}