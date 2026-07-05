package com.autodoc.project.repositories

import com.autodoc.project.services.news.NewsEntity
import kotlinx.coroutines.flow.Flow

internal interface NewsRepository {
    suspend fun add(entity: NewsEntity)
    suspend fun delete(entity: NewsEntity)
    fun load(): List<NewsEntity>
    fun loadAsFlow(): Flow<List<NewsEntity>>
    fun loadAsFlow(id: Int): Flow<NewsEntity?>
}