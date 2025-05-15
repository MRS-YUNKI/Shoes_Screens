package com.example.shoes.data.domain.usecase

import androidx.core.content.contentValuesOf
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.shoes.data.local.localStorage
import com.example.shoes.data.model.RegistrationRequest
import com.example.shoes.data.remote.NetworkResponse
import com.example.shoes.data.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class AuthUseCase(
    private val localStorage: localStorage,
    private val authRepository: AuthRepository
) {
    val token: Flow<String> = localStorage.tokenFlow
    suspend fun getToken(): String = localStorage.getToken()

    suspend fun registration(request: RegistrationRequest): Flow<NetworkResponse> = flow {
        try {
            emit(NetworkResponse.Loading)
            val (user, token) = authRepository.registration(request)
            localStorage.setToken(token)
            emit(NetworkResponse.Success(user))
        } catch (e: Exception) {
            emit(NetworkResponse.Error(e.message ?: "Registration failed"))
        }
    }
}