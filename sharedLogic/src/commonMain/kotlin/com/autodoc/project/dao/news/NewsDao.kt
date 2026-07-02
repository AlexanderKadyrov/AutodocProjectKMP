package com.autodoc.project.dao.news

import com.autodoc.project.services.news.NewsEntity

import kotlinx.coroutines.flow.Flow

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Dao

@Dao
interface NewsDao {

    @Insert
    suspend fun insert(model: NewsEntity)

    @Query("SELECT * FROM NewsEntity")
    fun getAllAsFlow(): Flow<List<NewsEntity>>
}