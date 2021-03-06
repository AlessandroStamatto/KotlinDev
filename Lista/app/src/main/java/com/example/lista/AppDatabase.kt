package com.example.lista

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Afazer::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun afazerDao(): AfazerDao
}