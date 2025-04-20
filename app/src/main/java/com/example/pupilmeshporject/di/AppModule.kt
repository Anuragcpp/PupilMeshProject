package com.example.pupilmeshporject.di

import android.content.Context
import androidx.room.Room
import com.example.pupilmeshporject.data.local.dao.UserDao
import com.example.pupilmeshporject.data.local.database.AppDatabase
import com.example.pupilmeshporject.data.repository.AuthRepositoryImp
import com.example.pupilmeshporject.domain.repository.AuthRepository
import com.example.pupilmeshporject.domain.usecases.AuthUserCases
import com.example.pupilmeshporject.domain.usecases.GetUser
import com.example.pupilmeshporject.domain.usecases.InsertUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_db"
        ).build()
    }

    @Provides
    fun provideUserDao(db : AppDatabase) : UserDao = db.userDao()

    @Provides
    @Singleton
    fun provideAuthRepository( userDao: UserDao) : AuthRepository {
        return AuthRepositoryImp(userDao)
    }

    @Provides
    fun provideAuthUseCases( repository: AuthRepository) : AuthUserCases {
        return AuthUserCases(
            getUser = GetUser(repository),
            insertUser = InsertUser(repository)
        )
    }
}