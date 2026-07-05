package com.autodoc.project.providers.news

import com.autodoc.project.repositories.NewsRepository
import com.autodoc.project.services.news.NewsEntity

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

import kotlin.getValue

class NewsDatabaseProvider: NewsProvider, KoinComponent {

    private val newsRepository: NewsRepository by inject()

    override suspend fun fetchNews(offset: Int, limit: Int): List<NewsEntity> {
        return newsRepository.loadAll()
    }
}