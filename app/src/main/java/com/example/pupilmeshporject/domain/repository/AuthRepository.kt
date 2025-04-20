package com.example.pupilmeshporject.domain.repository

import com.example.pupilmeshporject.domain.model.User

interface AuthRepository {
    suspend fun getUser(email : String) : User?
    suspend fun insertUser(user: User)
}