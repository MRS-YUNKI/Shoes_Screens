package com.example.shoes.data.local

import com.example.shoes.data.model.SaveTokenRequest
import com.example.shoes.data.model.TokenResponse

interface AuthLocalStore {
    suspend fun getToken(): TokenResponse
    suspend fun setToken(saveTokenRequest: SaveTokenRequest): Boolean

}