package com.example.pupilmeshporject.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pupilmeshporject.data.local.dao.UserDao
import com.example.pupilmeshporject.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao () : UserDao
}