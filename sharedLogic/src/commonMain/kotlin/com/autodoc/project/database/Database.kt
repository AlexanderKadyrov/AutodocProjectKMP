package com.autodoc.project.database

import com.autodoc.project.services.news.NewsEntity

import androidx.room.ConstructedBy
import androidx.room.RoomDatabase
import androidx.room.Database

@Database(entities = [NewsEntity::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
internal abstract class AppDatabase: RoomDatabase() {
    abstract fun getDao(): NewsDao
}