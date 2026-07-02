package com.autodoc.project.database

import androidx.sqlite.driver.bundled.BundledSQLiteDriver

import androidx.room.RoomDatabase
import androidx.room.Room

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

import platform.Foundation.NSHomeDirectory

internal fun getDatabase(): AppDatabase {
    return getDatabaseBuilder().build()
}

private fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val dbFilePath = NSHomeDirectory() + "/database.db"
    return Room.databaseBuilder<AppDatabase>(dbFilePath)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
}