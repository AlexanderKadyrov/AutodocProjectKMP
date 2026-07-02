package com.autodoc.project.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.autodoc.project.services.news.NewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface NewsDao {

    @Insert
    suspend fun insert(entity: NewsEntity)

    @Query("SELECT * FROM NewsEntity")
    fun getAllAsFlow(): Flow<List<NewsEntity>>
}