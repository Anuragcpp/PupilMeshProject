package com.example.pupilmeshporject.domain.usecases

import com.example.pupilmeshporject.domain.model.User
import com.example.pupilmeshporject.domain.repository.AuthRepository
import javax.inject.Inject

class InsertUser @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(user: User) {
        repository.insertUser(user)
    }
}