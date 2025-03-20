package com.example.shoes.data.local.datastore

import android.content.Context
import com.example.shoes.data.local.AuthLocalStore
import com.example.shoes.data.model.SaveTokenRequest
import com.example.shoes.data.model.TokenResponse

class LocalDataStore(context: Context): AuthLocalStore {
    override suspend fun getToken(): TokenResponse {
        TODO("Not yet implemented")
    }

    override suspend fun setToken(saveTokenRequest: SaveTokenRequest): Boolean {
        TODO("Not yet implemented")
    }
}