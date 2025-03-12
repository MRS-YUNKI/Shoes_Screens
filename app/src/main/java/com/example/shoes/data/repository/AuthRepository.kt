package com.example.shoes.data.repository

interface AuthRepository {
    suspend fun registration()
    suspend fun login()

}