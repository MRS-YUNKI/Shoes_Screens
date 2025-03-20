package com.example.shoes.data.repository

import com.example.shoes.data.Auth
import com.example.shoes.data.model.RegistrationRequest
import com.example.shoes.data.model.TokenResponse
import com.example.shoes.data.remote.NetworkResponse
import kotlinx.coroutines.delay


class AuthRepository(private val auth: Auth) {
    suspend fun registration(registrationRequest: RegistrationRequest): TokenResponse {
        delay(3000)
        return auth.registration(registrationRequest)
    }
}