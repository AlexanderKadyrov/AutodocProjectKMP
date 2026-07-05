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

    override suspend fun loadAll(): List<NewsEntity> {
        return dao.getAll()
    }

    override fun loadAllAsFlow(): Flow<List<NewsEntity>> {
        return dao.getAllAsFlow()
    }

    override fun loadAsFlow(id: Int): Flow<NewsEntity?> {
        return dao.getByIdAsFlow(id)
    }
}