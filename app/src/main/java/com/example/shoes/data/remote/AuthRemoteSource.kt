package com.example.shoes.data.remote

import com.example.shoes.data.model.RegistrationRequest
import com.example.shoes.data.model.TokenResponse

interface AuthRemoteSource {
    suspend fun registration(registrationRequest: RegistrationRequest): TokenResponse
}