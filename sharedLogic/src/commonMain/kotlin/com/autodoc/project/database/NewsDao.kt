package com.autodoc.project.database

import com.autodoc.project.services.news.NewsEntity

import kotlinx.coroutines.flow.Flow

import androidx.room.OnConflictStrategy
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Dao

@Dao
internal interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: NewsEntity)

    @Delete
    suspend fun delete(entity: NewsEntity)

    @Query("SELECT * FROM NewsEntity")
    fun getAllAsFlow(): Flow<List<NewsEntity>>

    @Query("SELECT * FROM NewsEntity WHERE id = :id")
    fun getByIdAsFlow(id: Int): Flow<NewsEntity?>
}