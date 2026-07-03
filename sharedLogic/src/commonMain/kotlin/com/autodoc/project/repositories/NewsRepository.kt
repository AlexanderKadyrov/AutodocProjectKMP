package com.autodoc.project.repositories

import com.autodoc.project.services.news.NewsEntity
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun add(entity: NewsEntity)
    suspend fun delete(entity: NewsEntity)
    fun load(): Flow<List<NewsEntity>>
}