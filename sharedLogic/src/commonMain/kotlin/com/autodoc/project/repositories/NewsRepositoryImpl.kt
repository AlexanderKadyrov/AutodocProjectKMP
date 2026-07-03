package com.autodoc.project.repositories

import com.autodoc.project.services.news.NewsEntity
import com.autodoc.project.database.AppDatabase
import com.autodoc.project.database.NewsDao

import kotlinx.coroutines.flow.Flow

internal class NewsRepositoryImpl(
    private val database: AppDatabase
): NewsRepository {
    private val dao: NewsDao by lazy {
        database.getDao()
    }

    override suspend fun add(entity: NewsEntity) {
        dao.insert(entity)
    }

    override suspend fun delete(entity: NewsEntity) {
        dao.delete(entity)
    }

    override fun load(): Flow<List<NewsEntity>> {
        return dao.getAllAsFlow()
    }
}