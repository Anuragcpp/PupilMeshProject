package com.example.pupilmeshporject.domain.usecases

import com.example.pupilmeshporject.domain.model.User
import com.example.pupilmeshporject.domain.repository.AuthRepository
import javax.inject.Inject

class GetUser @Inject constructor(
    private val repository : AuthRepository
) {
    suspend operator fun invoke(email : String) : User? {
        return repository.getUser(email)
    }
}