package com.example.shoes.data.remote.retrofit

import com.example.shoes.data.model.RegistrationRequest
import com.example.shoes.data.model.TokenResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface Auth {
    @POST("/registration")
    suspend fun registration(@Body registrationRequest: RegistrationRequest): TokenResponse
}