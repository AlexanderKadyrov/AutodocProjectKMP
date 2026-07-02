package com.autodoc.project.database

import com.autodoc.project.services.news.NewsEntity

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import androidx.room.RoomDatabase
import androidx.room.Database
import kotlinx.coroutines.IO

@Database(entities = [NewsEntity::class], version = 1)
internal abstract class AppDatabase: RoomDatabase() {
    abstract fun getDao(): NewsDao
}

internal fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase {
    return builder
        .setQueryCoroutineContext(Dispatchers.IO)
        .setDriver(BundledSQLiteDriver())
        .build()
}