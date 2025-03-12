package com.example.shoes.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val URL = "http://0.0.0.0:8080"
object RetrofitClient {

    val retrofitBuilder = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofit by lazy {
        retrofitBuilder.create(Auth::class.java)
    }
}