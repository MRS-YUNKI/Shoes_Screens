package com.example.shoes.data.domain.usecase

import androidx.core.content.contentValuesOf
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.shoes.data.local.localStorage
import com.example.shoes.data.model.RegistrationRequest
import com.example.shoes.data.remote.NetworkResponse
import com.example.shoes.data.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class AuthUseCase(private val localStorage: localStorage,
                  private val authRepository: AuthRepository){
    val token = localStorage.tokenFlow
    fun registration(registrationRequest: RegistrationRequest): Flow<NetworkResponse> = flow {
        try {
            emit(NetworkResponse.Loading)
            val result = authRepository.registration(registrationRequest)
            localStorage.setToken(result.second)
            emit(NetworkResponse.Success(result))
        }
        catch (e: Exception) {
            e.message?.let {
                emit(NetworkResponse.Error(it))
                return@flow
            }
            emit(NetworkResponse.Error("Unknown Error"))
        }
    }
}