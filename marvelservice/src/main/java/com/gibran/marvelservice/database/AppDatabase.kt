package com.gibran.marvelservice.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gibran.marvelservice.database.converter.Converters
import com.gibran.marvelservice.database.dao.HeroDao
import com.gibran.marvelservice.model.Hero

//For simplification, the exportSchema is set to false
@Database(entities = [Hero::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun heroDao(): HeroDao

    companion object {
        const val DATABASE_NAME = "MarvelApp.db"
    }
}