package com.example.shoes.data.repository

import com.example.shoes.data.local.AuthLocalStore
import com.example.shoes.data.remote.AuthRemoteSource

class AuthRepositoryImpl (authLocalStore: AuthLocalStore,
                          authRemoteSource: AuthRemoteSource): AuthRepository {
    override suspend fun registration() {
        TODO("Not yet implemented")
    }

    override suspend fun login() {
        TODO("Not yet implemented")
    }
}