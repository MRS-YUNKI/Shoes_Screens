package com.example.shoes.data.remote.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val URL = "http://10.242.177.60:8080"
object RetrofitClient {
    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofit by lazy {
        retrofitBuilder.create(Auth::class.java)
    }
}