package com.example.pupilmeshporject.data.repository

import com.example.pupilmeshporject.data.local.dao.UserDao
import com.example.pupilmeshporject.data.local.entity.UserEntity
import com.example.pupilmeshporject.domain.model.User
import com.example.pupilmeshporject.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImp @Inject constructor(
    private val userDao: UserDao
) : AuthRepository {
    override suspend fun getUser(email: String): User? {
        return userDao.getUserByEmail(email)?.let {
            User(it.email,it.password)
        }
    }

    override suspend fun insertUser(user: User) {
        userDao.insertUser(UserEntity(user.email,user.password))
    }
}