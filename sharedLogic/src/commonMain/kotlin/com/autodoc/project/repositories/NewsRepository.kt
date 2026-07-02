package com.autodoc.project.repositories

import com.autodoc.project.services.news.NewsEntity
import com.autodoc.project.database.AppDatabase
import com.autodoc.project.database.NewsDao

import kotlinx.coroutines.flow.Flow

internal class NewsRepository(
    private val database: AppDatabase
) {
    private val dao: NewsDao by lazy {
        database.getDao()
    }

    suspend fun add(entity: NewsEntity) {
        dao.insert(entity)
    }

    fun load(): Flow<List<NewsEntity>> {
        return dao.getAllAsFlow()
    }
}